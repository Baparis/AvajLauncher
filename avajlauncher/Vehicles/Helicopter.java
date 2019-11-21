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
public class Helicopter extends Aircraft implements Flyable {

    private WeatherTower _weatherTower;

    Aircraft af;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        System.out.print("Helicopter#" + _name + "(" + _id + "): ");
        switch (_weatherTower.getWeather(_coordinates)) {
            case "Sun":
                System.out.print("VRRRRR");
                _coordinates = new Coordinates(_coordinates.getLongitude() + 10, _coordinates.getLatitude(), _coordinates.getHeight() + 2);
                break;
            case "Rain":
                System.out.print("WET VRRRRR");
                _coordinates = new Coordinates(_coordinates.getLongitude() + 5, _coordinates.getLatitude(), _coordinates.getHeight());
                break;
            case "Fog":
                System.out.print("CONFUSED VRRRRRR");
                _coordinates = new Coordinates(_coordinates.getLongitude() + 1, _coordinates.getLatitude(), _coordinates.getHeight());
                break;
            case "Snow":
                System.out.print("COLD VRRRRRR");
                _coordinates = new Coordinates(_coordinates.getLongitude(), _coordinates.getLatitude(), _coordinates.getHeight() - 12);
                break;
        }
        System.out.print("\n");
        if (_coordinates.getHeight() == 0) {
            System.out.print("Helicopter#" + _name + "(" + _id + ")" + "Landing.\n");
            _weatherTower.unregister(this);
            System.out.print("Tower says: Helicopter#" + _name + "(" + _id + ")" + "unregistered from weather tower.\n");
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        _weatherTower = weatherTower;
        _weatherTower.register(this);
        System.out.print("Tower says: Helicopter#" + _name + "(" + _id + ")" + "registered to weather tower.\n");
    }
}
