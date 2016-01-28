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

public class MonsterTest {
    
    private Unit unit = new Unit(50, 50);
    private Monster monster = new Monster(45, 45);
    
    @Test
    public void killWhenNotInSamePlace() {
        monster.kill(unit);
        assertTrue(!monster.isDead());
        
    }
    
    
    @Test
    public void moveAndKill() {
        unit.move(-5, -5);
        monster.kill(unit);
        assertTrue(monster.isDead());
    }
     
    @Test
    public void moveMonster() {
        monster.move(15, 15);
        assertEquals(60, monster.getX());
        assertEquals(60, monster.getY());
    }
    
    
}
