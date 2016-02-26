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
 * Monsterit luova TimerTask.
 *
 * @see fi.rajaro.units.Map#spawnMonsters(int)
 */

public class MonsterSpawn extends TimerTask {

    private Map map;

    public MonsterSpawn(Map map) {
        this.map = map;
    }

    @Override
    public void run() {
        map.spawnMonsters(30);

    }
}
