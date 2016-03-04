package fi.rajaro.gui;



import javax.swing.SwingUtilities;


public class Main {

    public static void main(String[] args) {

        Interface interf = new Interface();
        SwingUtilities.invokeLater(interf);

    }
}
