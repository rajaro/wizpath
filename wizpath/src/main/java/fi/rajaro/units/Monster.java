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
/**
 * Monsterit määrittelevä luokka
 *
 * @author jaro
 */
import java.awt.Color;
import java.awt.Graphics;

public class Monster extends Unit {

    private boolean dead;
    private boolean playerDead;
    private int x;
    private int y;
    private int direction;

    public Monster() {
        super(0, 0);

    }

    public Monster(int x, int y) {
        super(x, y);
        this.x = x;
        this.y = y;
        dead = false;
        playerDead = false;
    }

    /**
     * Liikutetaan monsteria, jos se on elossa. Liikkumisen suunta lasketaan
     * direction-muuttujan perusteella.
     */
    public void act() {
        if (this.dead == false) {
            if (this.direction % 2 == 0) {
                move(1, 2);
            } else {
                move(-1, 2);
            }
        }
    }

    public int getDirection() {
        return this.direction;
    }

    /**
     * Asetetaan suuntamuuttuja monsterille Suunta perustuu jakojäännökseen
     * luvulla 2 jaettaessa.
     *
     * @param direction monsterin suunta
     */
    public void setDirection(int direction) {
        this.direction = direction;
    }

    public boolean isDead() {
        return this.dead;

    }

    @Override
    public void move(int xchange, int ychange) {
        setX(this.x + xchange);
        setY(this.y + ychange);
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Tapetaan monsteri, jos se osuu ammukseen.
     *
     * @param unit monsterin tappava ammus
     * @return palautetaan true, jos tappaminen onnistui
     */
    public boolean killBolt(Unit unit) {
        if (((unit.getX() - this.x < 8) && (unit.getX() - this.x > -3))
                && Math.abs(unit.getY() - this.y) < 10) {
            this.dead = true;
            return true;
        }
        return false;

    }

    /**
     * Metodi kokeilee, osuuko monsteri pelaajaan, ja palauttaa true jos osuu
     * sekä tappaa monsterin.
     *
     * @param player pelaaja, jonka koordinaatteihin verrataan
     * @return palauttaa true jos pelaaja osuu monsteriin
     */
    public boolean killPlayer(Player player) {
        if (((player.getX() - this.x) < 8) && (player.getX() - this.x > -18)
                && (player.getY() - this.y < 5) && (player.getY() - this.y > -18)) {
            this.dead = true;
            return true;
        }
        return false;
    }

    public void draw(Graphics graphics) {
        graphics.fillOval(x, y, 10, 10);
        graphics.setColor(Color.RED);

    }
}
