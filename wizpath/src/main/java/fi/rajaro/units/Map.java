package fi.rajaro.units;

/**
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
    private JLabel gameStart;
    public int inGame;
    private int monstersNum;

    /**
     * Luodaan kenttä, ja alustetaan sinne pelaaja, ammus, monsterit sekä
     * pelaajan elämät ja pisteet.
     *
     * @param player pelaaja
     * @param monstersNum monsterien lukumäärä
     */
    public Map(Player player, int monstersNum) {
        gameStart = new JLabel("Press enter to start game");
        gameStart.setBounds(150, 150, 200, 200);
        inGame = 0;
        this.monsters = new ArrayList<>();
        bolt = new Bolt(20, 440);
        super.setBackground(Color.BLACK);
        this.player = player;
        player.setBolt(bolt);
        spawnMonsters(monstersNum);
        this.monstersNum = monstersNum;
        playerLives = 3;
        scoreLabel = new JLabel();
        scoreLabel.setBounds(102, 7, 300, 10);
        scoreLabel.setText(scoreUpdate());
        gameOver = new GameOverScreen();
        lastHit = 0;
    }

    /**
     * Monsterit luova metodi, joka generoi satunnaiset luvut monsterin
     * alkukoordinaateiksi Monstereille annetaan suuntamuuttuja kasvavassa
     * järjestyksessä nollasta monsterien lukumäärään.
     *
     * @param monsters lukumäärä, jonka verran monstereita luodaan kerralla
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
                    scoreLabel.setText(scoreUpdate());
                    lastHit = System.currentTimeMillis();
                }
            }
            if (!this.monsters.get(i).isDead()) {
                if (this.monsters.get(i).killBolt(bolt)) {
                    score++;
                    scoreLabel.setText(scoreUpdate());

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

    /**
     * Päivitetään piste- ja elämätilanne.
     *
     * @return palauttaa pisteet ja elämät
     */
    public String scoreUpdate() {
        return "Score: " + this.score + " - Lives: " + playerLives + "  (Press enter to reset)";
    }

    public ArrayList<Monster> getMonsters() {
        return this.monsters;
    }

    public Map() {
        super.setBackground(Color.WHITE);

    }

    /**
     * Alustetaan Map uudestaan. Asetetaan samat arvot kuin konstruktorissa.
     */
    public void startGame() {
        this.inGame = 1;
        repaint();
        this.removeAll();
        this.monsters = new ArrayList<>();
        player.setX(20);
        player.setY(440);
        score = 0;
        bolt = new Bolt(20, 440);
        player.setBolt(bolt);
        playerLives = 3;
        scoreLabel.setText(scoreUpdate());
        gameOver = new GameOverScreen();
        lastHit = 0;
    }

    /**
     * Maalataan aloitusviesti, ja kun käyttäjä painaa Enteriä niin aloitetaan
     * itse peli. Kun peli loppuu (eli pelaajan elämät loppuvat), maalataan
     * näytölle lopetusviesti.
     *
     * @param graphics graphics
     */
    @Override
    protected void paintComponent(Graphics graphics) {
        if (this.inGame == 0) {
            super.paintComponent(graphics);
            this.add(gameStart);
        } else {
            this.remove(gameStart);
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
}
