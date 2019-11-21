/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avajlauncher;

import avajlauncher.Managers.WeatherTower;

/**
 *
 * @author Stari
 */
public interface Flyable {

    public void updateConditions();

    public void registerTower(WeatherTower WeatherTower);

}
