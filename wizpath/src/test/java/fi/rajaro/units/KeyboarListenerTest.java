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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static org.junit.Assert.*;
import org.junit.*;
public class KeyboarListenerTest {
    
    private Player player = new Player(50, 50);
    private Map map = new Map(player, 30);
    private KeyboardListener kbl = new KeyboardListener(player, map);
    private KeyEvent e;
    
    
    public void pressKey(int keyCode) {
        if (keyCode == KeyEvent.VK_LEFT) {
            player.setAct(-2);
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            player.setAct(2);
        }
    }
    
    public void releaseKey(int keyCode) {
        if (keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_RIGHT) {
            player.setAct(0);
        }
    }
    
    @Test
    public void keyPressedTest() {
        pressKey(KeyEvent.VK_LEFT);
        player.act();
        assertEquals(48, player.getX());
        player.setAct(0);
        player.act();
        assertEquals(48, player.getX());
    }
    @Test
    public void keyPressedTest2() {
        pressKey(KeyEvent.VK_RIGHT);
        player.act();
        assertEquals(52, player.getX());
        player.setAct(0);
        player.act();
        assertEquals(52, player.getX());
    }
    @Test
    public void keyReleasedTest() {
      pressKey(KeyEvent.VK_RIGHT);
      player.act();
      releaseKey(KeyEvent.VK_RIGHT);
      player.act();
      assertEquals(52, player.getX());
    }
}
