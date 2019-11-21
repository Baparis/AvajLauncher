package avajlauncher.Managers;

/**
 *
 * @author Stari
 */
import avajlauncher.Vehicles.Coordinates;
import java.util.Random;

public class WeatherProvider {

    private static WeatherProvider _weatherProvider = new WeatherProvider();
    private String _weather;

    private WeatherProvider() {
    }

    public static WeatherProvider getProvider() {
        return WeatherProvider._weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        Random rand = new Random();
        switch (((coordinates.getHeight() + coordinates.getLatitude() + coordinates.getLongitude()) + rand.nextInt(12)) % 4) {
            case 0:
                return "Sun";
            case 1:
                return "Rain";
            case 2:
                return "Fog";
            case 3:
                return "Snow";
        }
        return "Snow";
    }
}
