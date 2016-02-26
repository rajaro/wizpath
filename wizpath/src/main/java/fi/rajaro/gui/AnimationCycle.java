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
import fi.rajaro.units.Map;
import java.util.TimerTask;

/**
 * Animaatiosta huolehtiva TimerTask.
 *
 * @see fi.rajaro.units.Map#animationCycle()
 */
public class AnimationCycle extends TimerTask {

    private Map map;

    public AnimationCycle(Map map) {
        this.map = map;
    }

    @Override
    public void run() {
        try {
            map.animationCycle();
        } catch (Exception ex) {
            ex.getMessage();
        }
    }

}
