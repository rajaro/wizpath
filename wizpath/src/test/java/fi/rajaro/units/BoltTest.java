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

public class BoltTest {
    private Bolt bolt = new Bolt(10, 10);
    
    @Test
    public void shootTest() {
        bolt.act();
        assertEquals(6, bolt.getY());
        bolt.shoot(15, 15);
        bolt.act();
        assertEquals(11, bolt.getY());
    }
    
}
