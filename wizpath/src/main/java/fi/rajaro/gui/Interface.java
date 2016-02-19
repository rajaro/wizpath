package fi.rajaro.gui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jaro
 */
import fi.rajaro.units.KeyboardListener;
import fi.rajaro.units.Bolt;
import fi.rajaro.units.Map;
import fi.rajaro.units.Monster;
import fi.rajaro.units.Player;
import fi.rajaro.units.Unit;
import java.awt.Container;
import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.Component;
import javax.swing.InputMap;
import javax.swing.ActionMap;
import java.util.TimerTask;
import java.util.Timer;
import javax.swing.JLabel;

public class Interface extends JFrame implements Runnable {

    private JFrame frame;
    private Map map;
    private Player player;
    private Monster monster;
    private Boolean inGame;
    private AnimationCycle anim;
    private MonsterSpawn mons;
    private JLabel score;

    public Interface() {
    }

    @Override
    public void run() {
        frame = new JFrame("Map");
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
        Timer animator = new Timer();
        Timer monsterSpawner = new Timer();
        animator.scheduleAtFixedRate(anim, 1000, 25);
        monsterSpawner.scheduleAtFixedRate(mons, 4000, 4000); 
   

     
    }

    private void createComponents(Container container) {
        player = new Player(20, 440);
        monster = new Monster(50, 50);
        map = new Map(player, 30);
        container.add(map);
        anim = new AnimationCycle(map);
        mons = new MonsterSpawn(map);
        Bolt bolt = new Bolt(20, 440);

        frame.addKeyListener(new KeyboardListener(player, map));
    }

    public JFrame getFrame() {
        return frame;
    }
}
