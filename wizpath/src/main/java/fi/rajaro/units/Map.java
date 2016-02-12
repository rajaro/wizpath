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
import java.util.Timer;
import java.util.TimerTask;
import fi.rajaro.gui.*;
import java.util.ArrayList;
import java.util.Random;
/**
 * Pelikentän määrittävä luokkka
 * @author jaro
 */
public class Map extends JPanel {

    private Player player;
    private ArrayList<Monster> monsters;
    private Bolt bolt;
    private Timer timer;
    private int playerLives;

    public Map(Player player, int monsters) {
       this.monsters = new ArrayList<Monster>();
        bolt = new Bolt(20, 440);
        super.setBackground(Color.WHITE);
        this.player = player;
        player.setBolt(bolt);
        spawnMonsters(monsters);
    }
    /**
     * Monsterit luova metodi, joka generoi satunnaiset luvut monsterin alkukoordinaateiksi
     * Monstereille annetaan suuntamuuttuja kasvavassa järjestyksessä nollasta monsterien lukumäärään.
     * @param monsters lukumäärä, jonka verran monstereita luodaan kerralla
     * 
     */
    public void spawnMonsters(int monsters) {
        for (int i = 0; i < monsters; i++) {
            Random randomint = new Random();
            int randomx = randomint.nextInt(500);
            int randomy = randomint.nextInt(30);
            Monster moso = new Monster(randomx, randomy);
            moso.setDirection(i);
            this.monsters.add(moso);

        }
    }
/**
 * Liikuttaa kaikkia kartalla olevia, tarkastaa osuvatko jotkut toisiinsa ja kutsuu lopuksi repaint() metodia
 */
    public void animationCycle() {
        player.act();
        for (int i = 0; i < this.monsters.size(); i++) {
            this.monsters.get(i).act();
        }
        bolt.act();
        checkCollision();
        repaint();
    }
/**
 * Tarkastaa, osuuko jokin monsteri joko pelaajaan tai ammukseen
 */
    public void checkCollision() {
        for (int i = 0; i < this.monsters.size(); i++) {
            if (this.monsters.get(i).kill(player)) {
                playerLives--;
            }
            this.monsters.get(i).kill(bolt);
        }

    }
    
    public void setLives(int lives) {
        this.playerLives = lives;
        
    }
    
    public int getLives() {
        return this.playerLives;
    }

    public Map() {
        super.setBackground(Color.WHITE);

    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        player.draw(graphics);
        for (int i = 0; i < this.monsters.size(); i++) {
            this.monsters.get(i).draw(graphics);
        }
        bolt.draw(graphics);
    }
}
