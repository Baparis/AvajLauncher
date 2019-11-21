package avajlauncher.Vehicles;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Stari
 */

public class Coordinates {
    private int _longitude;
    private int _latitude;
    private int _height;
    
    Coordinates(int longitude, int latitude, int height)
    {
        _longitude = longitude;
        _latitude = latitude;
         if (height < 0)
             _height = 0;
         else if (height > 100)
             _height = 100;
         else
            _height = height;
    }
    
    public int getLongitude() { return _longitude; }
    public int getLatitude() { return _latitude; }
    public int getHeight() { return _height; }
    
    
}
