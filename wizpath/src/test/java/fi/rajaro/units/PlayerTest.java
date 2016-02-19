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
import fi.rajaro.units.Player;
import org.junit.*;
import static org.junit.Assert.assertEquals;

public class PlayerTest {
    
    public Player player = new Player(50, 50);
    int originalX = 50;
    int originalY = 50;
    
    @Test
    public void moveLeftTest() {
        player = new Player(50, 50);
        player.move(-2, 0);
        assertEquals(originalX - 2, player.getX());
    }
    @Test
    public void moveRightTest() {
        player.move(2, 0);
        assertEquals(originalX + 2, player.getX());

    }
    
    @Test public void MoveRight2Test() {
        player.move(50, 0);
        assertEquals(originalX + 50, player.getX());
    }
    
    @Test public void playerActRightTest() {
        player.setAct(2);
        player.act();
        assertEquals(originalX + 2, player.getX());
    }
    
    @Test public void playerActLeftTest() {
        player.setAct(-2);
        player.act();
        assertEquals(originalX - 2, player.getX());
    }
    
    @Test public void playerActZeroTest() {
        player.setAct(0);
        player.act();
        assertEquals(originalX, player.getX());
    }
    
    @Test public void playerActUpTest() {
        player.setAct(1);
        player.act();
        assertEquals(originalY -2, player.getY());
    }
    
    @Test public void playerActDownTest() {
        player.setAct(-1);
        player.act();
        assertEquals(originalY + 2, player.getY());
    }

}

