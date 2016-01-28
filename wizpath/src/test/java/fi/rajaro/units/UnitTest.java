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

import org.junit.*;
import static org.junit.Assert.assertEquals;

public class UnitTest {
    private Unit unit = new Unit(50, 50);
    
    @Test
    public void moveLeft() {
        unit.move(-2, 0);
        assertEquals(48, unit.getX());
    }
    
    
    @Test
    public void moveToLeftBorder() {
        int i = 50;
        while (i > 0) {
            unit.move(-2, 0);
            i--;
        }
        assertEquals(0, unit.getX());
    }
    
    @Test
    public void moveRight() {
        unit.move(2, 0);
        assertEquals(52, unit.getX());
    }
    
    @Test
    public void moveToRightBorder() {
        int j = 50;
        while (j < 500) {
            unit.move(2, 0);
            j++;
        }
        assertEquals(480, unit.getX());
    }
    
    @Test
    public void moveUnderZero() {
        this.unit.move(-501, -501);
        assertEquals(0, unit.getX());
        assertEquals(0, unit.getY());
    }
}
