

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Component;

public class KeyboardListener implements KeyListener {
    
    private Player player;
    private Component component;
    
    public KeyboardListener(Player player, Component component) {
        this.player = player;
        this.component = component;
        
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            player.move(-3, 0);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            player.move(3, 0);
        }
        
        component.repaint();
        
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }
    
}
