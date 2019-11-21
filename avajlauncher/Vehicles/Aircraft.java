package avajlauncher.Vehicles;
//import avajlauncher.Coordinates;




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Stari
 */
public class Aircraft {

    protected long _id;
    protected String _name;
    protected Coordinates _coordinates;
    private static long _idCounter = 1;

    protected Aircraft(String name, Coordinates coordinates) {
        _name = name;
        _coordinates = coordinates;
        _id = nextId();
    }

    private long nextId() {
        ++_idCounter;
        return _idCounter - 1;
    }
}
