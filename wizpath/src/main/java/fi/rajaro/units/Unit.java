/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.rajaro.units;

/**
 *
 * @author jaro
 */
public class Unit {
    
    private int x;
    private int y;
    
    public Unit(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    /**
     * muuttaa x- ja y-koordinaatteja parametrien verran. Koordinaattien rajat 0 ja 480.
     * 
     * @param xchange x-koordinaatin muutos
     * @param ychange y-koordinaatin muutos
     */
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
        } else if (this.y + ychange >= 480) {
            this.y = 480;  
        } else {
        this.y += ychange;
        }
    }
    
    
}
