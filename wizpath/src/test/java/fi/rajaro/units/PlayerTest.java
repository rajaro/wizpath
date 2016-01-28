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

}

