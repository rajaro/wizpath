/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Graphics;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jaro
 */
public class PlayerTest {
    
    public PlayerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getX method, of class Player.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        Player instance = null;
        int expResult = 0;
        int result = instance.getX();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getY method, of class Player.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        Player instance = null;
        int expResult = 0;
        int result = instance.getY();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of move method, of class Player.
     */
    @Test
    public void testMove() {
        System.out.println("move");
        int xchange = 0;
        int ychange = 0;
        Player instance = null;
        instance.move(xchange, ychange);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of piirra method, of class Player.
     */
    @Test
    public void testPiirra() {
        System.out.println("piirra");
        Graphics graphics = null;
        Player instance = null;
        instance.piirra(graphics);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
