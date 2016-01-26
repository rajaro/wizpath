package wizpath.wizpath;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jaro
 */

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Interface implements Runnable {

    private JFrame frame;

    public Interface() {
    }

    @Override
    public void run() {
        frame = new JFrame("Map");
        frame.setPreferredSize(new Dimension(500, 500));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        Player player = new Player(20, 440);
        Map map = new Map(player);
        container.add(map);

        frame.addKeyListener(new KeyboardListener(player, map));
    }

    public JFrame getFrame() {
        return frame;
    }
}