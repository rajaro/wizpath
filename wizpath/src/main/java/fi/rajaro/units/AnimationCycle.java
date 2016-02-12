/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.rajaro.units;

/**
 *
 * @author jaro
 */

import java.util.Timer;
import java.util.TimerTask;
/**
     * Animaatiosta huolehtiva TimerTask
     * @see fi.rajaro.units.Map#animationCycle() 
     */
public class AnimationCycle extends TimerTask {
    private Map map;
    
    public AnimationCycle(Map map) {
        this.map = map;
    }
    
    public void run() {
        map.animationCycle();
    }
    
}
