package fi.rajaro.units;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jaro
 */
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JLabel;
import fi.rajaro.gui.GameOverScreen;

/**
 * Pelikentän määrittävä luokkka.
 *
 * @author jaro
 */
public final class Map extends JPanel {

    /**
     * Pelikenttä, joka sisältää pelaajan, mosnterit, ammuksen, pisteet sekä
     * int-muodossa että JLabel varattu pisteille. Lisäksi kartalle annetaan
     * gameOverScreen, jota kutsutaan pelin loppuessa. lastHit kertoo
     * viimeisimmän osuman pelaajaan.
     */
    private Player player;
    private ArrayList<Monster> monsters;
    private Bolt bolt;
    private int score;
    private int playerLives;
    private JLabel scoreLabel;
    private GameOverScreen gameOver;
    private double lastHit;

    /**
     * Luodaan kenttä, ja alustetaan sinne pelaaja, ammus, monsterit sekä
     * pelaajan elämät ja pisteet.
     *
     * @param player pelaaja
     * @param monsters monsterien lukumäärä
     */
    public Map(Player player, int monsters) {
        this.monsters = new ArrayList<>();
        bolt = new Bolt(20, 440);
        super.setBackground(Color.BLACK);
        this.player = player;
        player.setBolt(bolt);
        spawnMonsters(monsters);
        playerLives = 3;
        scoreLabel = new JLabel();
        scoreLabel.setBounds(180, 10, 300, 10);
        scoreLabel.setText("Score: " + score + " - Lives: " + playerLives);
        gameOver = new GameOverScreen();
        lastHit = 0;
    }

    /**
     * Monsterit luova metodi, joka generoi satunnaiset luvut monsterin
     * alkukoordinaateiksi Monstereille annetaan suuntamuuttuja kasvavassa
     * järjestyksessä nollasta monsterien lukumäärään.
     *
     * @param monsters lukumäärä, jonka verran monstereita luodaan kerralla
     *
     */
    public void spawnMonsters(int monsters) {
        if (playerLives > 0) {
            for (int i = 0; i < monsters; i++) {
                Random randomint = new Random();
                int randomx = randomint.nextInt(500);
                int randomy = randomint.nextInt(30);
                Monster moso = new Monster(randomx, randomy);
                moso.setDirection(i);
                this.monsters.add(moso);
            }

        }
    }

    /**
     * Jos pelajaalla on elämiä jäljellä, liikuttaa kaikkia kartalla olevia,
     * tarkastaa osuvatko jotkut toisiinsa ja kutsuu lopuksi repaint() metodia.
     *
     * @throws java.lang.Exception heittää exceptionin
     */
    public void animationCycle() throws Exception {
        if (playerLives > 0) {
            player.act();
            for (int i = 0; i < this.monsters.size(); i++) {
                this.monsters.get(i).act();
            }
            bolt.act();
            checkCollision();
            repaint();
        }

    }

    /**
     * Tarkastaa, osuuko jokin monsteri joko pelaajaan tai ammukseen ja
     * päivitetään score sekä playerLives -muuttujat. Pelaaja ei voi menettää
     * elämää useammin kuin kerran sekunnissa.
     *
     * @throws java.lang.Exception heittää exceptionin
     */
    public void checkCollision() throws Exception {

        for (int i = 0; i < this.monsters.size(); i++) {

            if (this.monsters.get(i).killPlayer(player)) {
                if (System.currentTimeMillis() - lastHit > 1000) {
                    playerLives--;
                    scoreLabel.setText("Score: " + this.score + " - Lives: " + playerLives);
                    lastHit = System.currentTimeMillis();
                }
            }
            if (!this.monsters.get(i).isDead()) {
                if (this.monsters.get(i).killBolt(bolt)) {
                    score++;
                    scoreLabel.setText("Score: " + this.score + " - Lives: " + playerLives);

                }
            }
        }

    }

    public void setLives(int lives) {
        this.playerLives = lives;

    }

    public int getLives() {
        return this.playerLives;
    }

    public int getScore() {
        return this.score;
    }

    public ArrayList<Monster> getMonsters() {
        return this.monsters;
    }

    public Map() {
        super.setBackground(Color.WHITE);

    }

    @Override
    protected void paintComponent(Graphics graphics) {
        if (playerLives > 0) {
            super.paintComponent(graphics);
            graphics.setColor(Color.BLUE);
            player.draw(graphics);
            graphics.setColor(Color.RED);
            for (int i = 0; i < this.monsters.size(); i++) {
                this.monsters.get(i).draw(graphics);
            }
            graphics.setColor(Color.WHITE);
            bolt.draw(graphics);
            add(scoreLabel);
        } else {
            super.paintComponent(graphics);
            this.add(gameOver.gameOver(score));

        }
    }
}
