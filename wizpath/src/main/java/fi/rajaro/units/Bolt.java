/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package fi.rajaro.units;


import java.awt.Graphics;

// A bolt that the player shoots to kill monsters
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
    
    public void shoot(Player player) {
        this.x = player.getX();
        this.y = player.getY();
        
    }
    
    
    
    public void draw(Graphics graphics) {
        graphics.fillOval(this.x, this.y, 2, 10);
    }
}