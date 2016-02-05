package fi.rajaro.units;



import javax.swing.ActionMap;
import javax.swing.InputMap;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Component;
import javax.swing.JComponent;
import java.awt.AWTKeyStroke;

public class KeyboardListener implements KeyListener {
    
    private Player player;
    private Map component;
    
    public KeyboardListener(Player player, Map component) {
        this.player = player;
        this.component = component;
        
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            player.setAct(-2);
            //player.move(-2, 0);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            player.setAct(2);
           // player.move(2, 0);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            component.animationCycle();
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            Bolt bolt = new Bolt();
            bolt.setX(player.getX());
            bolt.setY(player.getY());
            player.shoot(bolt);
        }
        component.animationCycle();
        component.repaint();
        
        
    }
    
    
    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            player.setAct(0);
        }
         else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            player.setAct(0);
    }
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

}
