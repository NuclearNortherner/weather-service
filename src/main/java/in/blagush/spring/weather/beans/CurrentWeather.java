package in.blagush.spring.weather.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Main class for weather parameters
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentWeather {

    private String name;
    private Weather[] weather;
    private Main main;
    private Wind wind;

    public CurrentWeather() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Weather[] getWeather() {
        return weather;
    }

    public void setWeather(Weather[] weather) {
        this.weather = weather;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }
}
