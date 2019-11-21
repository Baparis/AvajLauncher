/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avajlauncher.Vehicles;

import avajlauncher.Flyable;
import avajlauncher.Vehicles.Coordinates;
import avajlauncher.Vehicles.Baloon;
import avajlauncher.Vehicles.JetPlane;
import avajlauncher.Vehicles.Helicopter;

/**
 *
 * @author Stari
 */
public class AircraftFactory {

    public Flyable newAircraft(String type, String name, int Longitude, int Latitude, int Height) {
        Coordinates coord = new Coordinates(Longitude, Latitude, Height);

        switch (type) {
            case "Helicopter":
                return new Helicopter(name, coord);
            case "JetPlane":
                return new JetPlane(name, coord);
            case "Baloon":
                return new Baloon(name, coord);
        }
        return null;
    }

}
