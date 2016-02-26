/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.rajaro.gui;

/**
 *
 * @author jaro
 */
import javax.swing.JPanel;

import javax.swing.JLabel;

public class GameOverScreen extends JPanel {

    /**
     * Luo pelin loppuessa tekstin ruudulle, jossa ilmoitetaan pelin loppuneen
     * ja pisteet.
     *
     * @param score pelaajan pisteet
     * @return palauttaa JLabel -muodossa ilmoituksen
     */
    public JLabel gameOver(int score) {
        JLabel gameOverText = new JLabel();
        gameOverText.setBounds(150, 150, 300, 300);
        gameOverText.setText("GAME OVER! Score: " + score);
        return gameOverText;
    }
}
