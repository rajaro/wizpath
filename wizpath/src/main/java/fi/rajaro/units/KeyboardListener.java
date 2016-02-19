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

    /**
     * Liikutetaan pelaajaa liikkumaan näppäinten mukaan.
     *
     * @see fi.rajaro.units.Player#act()
     * @param e painettu näppäin
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            player.setAct(-2);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            player.setAct(2);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            player.setAct(-1);
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            player.setAct(1);
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            player.shoot(player.getBolt());
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            player.setAct(0);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            player.setAct(0);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            player.setAct(0);
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            player.setAct(0);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

}
