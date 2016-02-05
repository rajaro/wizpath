package fi.rajaro.units;

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
import java.util.Timer;
import java.util.TimerTask;
import fi.rajaro.gui.*;
import java.util.ArrayList;
import java.util.Random;

public class Map extends JPanel {

    private Player player;
    private ArrayList<Monster> monsters;
    private Bolt bolt;
    private Timer timer;

    public Map(Player player, int monsters) {
        this.bolt = new Bolt(20, 440);
        super.setBackground(Color.WHITE);
        this.player = player;
        this.monsters = new ArrayList<Monster>();
        for (int i = 0; i < monsters; i++) {
            Random randomint = new Random();
            int randomx = randomint.nextInt(500);
            Monster moso = new Monster(randomx, 20);
            moso.setDirection(i);
            this.monsters.add(moso);
            
        }
    }

    public void animationCycle() {
        player.act();
        for (int i = 0; i < this.monsters.size(); i++) {
            this.monsters.get(i).act();
        }
        bolt.act();
        repaint();
    }

    public Map() {
        super.setBackground(Color.WHITE);

    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        player.draw(graphics);
        for (int i = 0; i < this.monsters.size(); i++) {
            this.monsters.get(i).draw(graphics);
        }
        bolt.draw(graphics);
    }
}
