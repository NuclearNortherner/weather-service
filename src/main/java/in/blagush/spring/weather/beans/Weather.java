package in.blagush.spring.weather.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Class representing weather description
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {

    private String description;

    public Weather() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
