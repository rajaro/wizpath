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
import java.awt.*;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
/**
 * Pelaajan määrittelevä luokka
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

    public void kill() {
        this.dead = true;
    }
    
    public void shoot(Bolt bolt) {
        bolt.shoot(getX(), getY());
        
    }
/**
 * Asetetaan muuttuja, joka kertoo liikkumisen suunnan. -2 = vasen, 2 = oikea, 0 = ei mihinkään
 * @param act liikkumisen suunta
 */
    public void setAct(int act) {
        this.act = act;
    }
/**
 * Liikutetaan pelaajaa act -muuttujan arvon perusteella
 */
    public void act() {
        if (this.act == 2) {
            move(2, 0);
        } else if (this.act == -2) {
            move(-2, 0);
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
    }

    public void draw(Graphics graphics) {
        graphics.fillOval(x, y, 20, 20);
    }

}
