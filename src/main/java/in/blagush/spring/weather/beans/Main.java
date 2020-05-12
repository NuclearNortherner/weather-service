package in.blagush.spring.weather.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Class for temperature and human feels like temperature parameters
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Main {

    private double temp;
    private double feels_like;

    public Main() {
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getFeels_like() {
        return feels_like;
    }

    public void setFeels_like(double feels_like) {
        this.feels_like = feels_like;
    }
}
