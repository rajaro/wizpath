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

public class Monster extends Unit {

    private boolean dead;
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
    }
    
    public void act() {
        if (this.direction % 2 == 0) {
        move(1, 2);
        } else {
            move(-1, 2);
        }

    }
    
    public int getDirection() {
        return this.direction;
    }
    
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
    
    public void kill(Unit unit) {
        if (unit.getX() == this.x && unit.getY() == this.y) {
        this.dead = true;       
        }
    }
    

    public void draw(Graphics graphics) {
        graphics.fillOval(x, y, 10, 10);
    }
}
