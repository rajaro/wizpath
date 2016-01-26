/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jaro
 */
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
public class Map extends JPanel{
    private Player player;

    public Map(Player player) {
        super.setBackground(Color.WHITE);
        this.player = player;
    }
    
    public Map() {
        super.setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        player.piirra(graphics);
    }
}
    

