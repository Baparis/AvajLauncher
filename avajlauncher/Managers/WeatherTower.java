/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avajlauncher.Managers;

import avajlauncher.Managers.WeatherProvider;
import avajlauncher.Vehicles.Coordinates;

/**
 *
 * @author Stari
 */
public class WeatherTower extends Tower {

    static Tower tower = new Tower();

    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    public void changeWeather() {
        tower.conditionsChanged();
    }
}
