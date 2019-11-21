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
public class JetPlane extends Aircraft implements Flyable {

    Aircraft af;

    private WeatherTower _weatherTower;

    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        System.out.print("JetPlane#)" + _name + "(" + _id + "): ");
        switch (_weatherTower.getWeather(_coordinates)) {
            case "Sun":
                System.out.print("Let's enjoy the sunny day !");
                _coordinates = new Coordinates(_coordinates.getLongitude(), _coordinates.getLatitude() + 10, _coordinates.getHeight() + 2);
                break;
            case "Rain":
                System.out.print("What a sad day to fly");
                _coordinates = new Coordinates(_coordinates.getLongitude(), _coordinates.getLatitude() + 5, _coordinates.getHeight());
                break;
            case "Fog":
                System.out.print("Am i supposed to see something in this fog ?");
                _coordinates = new Coordinates(_coordinates.getLongitude(), _coordinates.getLatitude() + 1, _coordinates.getHeight());
                break;
            case "Snow":
                System.out.print("Winter has come ?");
                _coordinates = new Coordinates(_coordinates.getLongitude(), _coordinates.getLatitude(), _coordinates.getHeight() - 7);
                break;
        }
        System.out.print("\n");
        if (_coordinates.getHeight() == 0) {
            System.out.print("JetPlane#" + _name + "(" + _id + ")" + "Landing.\n");
            _weatherTower.unregister(this);
            System.out.print("Tower says: JetPlane#" + _name + "(" + _id + ")" + "unregistered from weather tower.\n");
        }

    }

    public void registerTower(WeatherTower weatherTower) {
        _weatherTower = weatherTower;
        _weatherTower.register(this);
        System.out.print("Tower says: JetPlane#" + _name + "(" + _id + ")" + "registered to weather tower.\n");
    }
}
