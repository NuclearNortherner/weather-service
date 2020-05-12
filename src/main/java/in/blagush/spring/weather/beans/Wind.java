package in.blagush.spring.weather.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Class representing wind parameters
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Wind {

    private double speed;

    public Wind() {
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
