/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avajlauncher.Vehicles;

import avajlauncher.Flyable;
import avajlauncher.Managers.WeatherTower;

/**
 *
 * @author Stari
 */
public class Baloon extends Aircraft implements Flyable {

    private WeatherTower _weatherTower;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        System.out.print("Baloon#" + _name + "(" + _id + "): ");
        switch (_weatherTower.getWeather(_coordinates)) {
            case "Sun":
                System.out.print("Let's zoom in the sunny day !");
                _coordinates = new Coordinates(_coordinates.getLongitude() + 2, _coordinates.getLatitude(), _coordinates.getHeight() + 4);
                break;
            case "Rain":
                System.out.print("I'm drenched, this was a bad idea");
                _coordinates = new Coordinates(_coordinates.getLongitude(), _coordinates.getLatitude(), _coordinates.getHeight() - 5);
                break;
            case "Fog":
                System.out.print("The trip has gone a lot more mysterious ?");
                _coordinates = new Coordinates(_coordinates.getLongitude(), _coordinates.getLatitude(), _coordinates.getHeight() - 3);
                break;
            case "Snow":
                System.out.print("Let it go, let it go !");
                _coordinates = new Coordinates(_coordinates.getLongitude(), _coordinates.getLatitude(), _coordinates.getHeight() - 15);
                break;
        }
        System.out.print("\n");
        if (_coordinates.getHeight() == 0) {
            System.out.print("Baloon#" + _name + "(" + _id + ")" + "Landing.\n");
            _weatherTower.unregister(this);
            System.out.print("Tower says: Baloon#" + _name + "(" + _id + ")" + "unregistered from weather tower.\n");
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        _weatherTower = weatherTower;
        _weatherTower.register(this);
        System.out.print("Tower says: Baloon#" + _name + "(" + _id + ")" + "registered to weather tower.\n");
    }
}
