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
import java.awt.Graphics;

/**
 * Pelaajan määrittelevä luokka.
 *
 * @author jaro
 */
public class Player extends Unit {

    private int x;
    private int y;
    private boolean dead;
    private int act;
    private Bolt bolt;

    public Player() {
        super(20, 440);
    }

    public Player(int x, int y) {
        super(x, y);
        this.x = x;
        this.y = y;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    public void setBolt(Bolt bolt) {
        this.bolt = bolt;
    }

    public Bolt getBolt() {
        return this.bolt;
    }

    public boolean dead() {
        return this.dead;
    }

    /**
     * Asettaa pelaajan kuolleeksi.
     */
    public void kill() {
        this.dead = true;
    }

    /**
     * Asetetaan ammuksen koordinaateiksi pelaajan tämänhetkiset koordinaatit.
     *
     * @param bolt pelaaja ammus
     */
    public void shoot(Bolt bolt) {
        bolt.shoot(getX(), getY());

    }

    /**
     * Asetetaan muuttuja, joka kertoo liikkumisen suunnan. 1 = ylös, -1 = alas,
     * -2 = vasen, 2 = oikea, 0 = ei mihinkään.
     *
     * @param act liikkumisen suunta
     */
    public void setAct(int act) {
        this.act = act;
    }

    /**
     * Liikutetaan pelaajaa act -muuttujan arvon perusteella.
     */
    public void act() {
        if (this.act == 2) {
            move(2, 0);
        } else if (this.act == -2) {
            move(-2, 0);
        } else if (this.act == 1) {
            move(0, -2);
        } else if (this.act == -1) {
            move(0, 2);
        }

    }

    @Override
    public void move(int xchange, int ychange) {
        if (this.x + xchange <= 0) {
            this.x = 0;
        } else if (this.x + xchange >= 480) {
            this.x = 480;
        } else {
            this.x += xchange;
        }
        if (this.y + ychange <= 0) {
            this.y = 0;
        } else if (this.y + ychange >= 460) {
            this.y = 460;
        } else {
            this.y += ychange;
        }
    }

    public void draw(Graphics graphics) {
        graphics.fillOval(x, y, 20, 20);

    }

}
