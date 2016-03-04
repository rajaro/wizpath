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
import static org.junit.Assert.*;

public class MapTest {
    Player player = new Player(10, 10);
    Map map = new Map(player, 10);
    Bolt bolt = new Bolt(10, 10);
    
    
    @Test
    public void spawnTest() {
        map.spawnMonsters(10);
        assertEquals(10, map.getMonsters().size());
        
    }
    
    @Test
    public void checkCollisionTest() throws Exception {
        Monster mon = new Monster(10, 10);
        map.getMonsters().add(mon);
        map.setLives(3);
        map.checkCollision();
        assertEquals(2, map.getLives());
    }
    
    @Test
    public void animationCycleTest() throws Exception {
        Monster mon = new Monster(10, 10);
        map.getMonsters().add(mon);
        map.setLives(3);
        player.setAct(0);
        map.animationCycle();
        assertEquals(2, map.getLives());
        
    }
    
    @Test
    public void startGameTest() {
        map.setLives(4);
        map.startGame();
        assertEquals(3, map.getLives());
        assertEquals(0, map.getScore());
        assertEquals(20, player.getX());
        assertEquals(440, player.getY());
    }
    

}
