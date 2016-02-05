package fi.rajaro.gui;

import fi.rajaro.units.*;
import fi.rajaro.gui.Interface;
import javax.swing.SwingUtilities;
import java.awt.EventQueue;
import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {

        Interface interf = new Interface();
        SwingUtilities.invokeLater(interf);

    }
}
