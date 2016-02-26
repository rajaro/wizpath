/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.rajaro.units;

import java.awt.Graphics;

/**
 * Ammus, jonka pelaaja ampuu.
 *
 * @author jaro
 */
public class Bolt extends Unit {

    private int x;
    private int y;

    public Bolt() {
        super(0, 0);
    }

    public Bolt(int x, int y) {
        super(x, y);
        this.x = x;
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

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Asettaa ammuksen koordinaatit parametrien mukaan.
     *
     * @param x uudet koordinaatit
     * @param y uudet koordinaatit
     */
    public void shoot(int x, int y) {
        setX(x);
        setY(y);
    }

    @Override
    public void move(int xchange, int ychange) {
        this.y = y + ychange;
    }

    /**
     * Ammuksen liikkumisen määrittävä metodi.
     *
     */
    public void act() {
        move(0, -4);
    }

    public void draw(Graphics graphics) {
        graphics.fillOval(this.x, this.y, 2, 10);
    }
}
