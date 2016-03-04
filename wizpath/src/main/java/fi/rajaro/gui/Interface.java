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
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.util.Timer;

public class Interface extends JFrame implements Runnable {

    private JFrame frame;
    private Map map;
    private Player player;
    private AnimationCycle anim;
    private MonsterSpawn mons;

    public Interface() {
    }

    @Override
    public void run() {
        frame = new JFrame("Wizpath");
        frame.setTitle("Wizpath");
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
        map = new Map(player, 30);
        container.add(map);
        anim = new AnimationCycle(map);
        mons = new MonsterSpawn(map);

        frame.addKeyListener(new KeyboardListener(player, map));
    }
    

    public JFrame getFrame() {
        return frame;
    }
}
