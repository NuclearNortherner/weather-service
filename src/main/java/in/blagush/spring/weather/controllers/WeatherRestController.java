package in.blagush.spring.weather.controllers;

import in.blagush.spring.weather.exceptions.CityNotFoundException;
import in.blagush.spring.weather.beans.CurrentWeather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
@PropertySource(value= {"classpath:application.properties"})
public class WeatherRestController {

    @Autowired
    private Environment environment;

    @GetMapping("weather/{city}")
    public CurrentWeather getCurrentWeather(@PathVariable String city, Model model) {

        if ("Gomel".equals(city)) {
            city = "Homyel";
        }

        RestTemplate restTemplate = new RestTemplate();
        String resourceUri = environment.getProperty("weather.server.url") + "?q=" + city + "&units=metric&appid=" +
                environment.getProperty("weather.server.appid");
        ResponseEntity<CurrentWeather> currentWeatherResponseEntity;

        try {

            currentWeatherResponseEntity = restTemplate.getForEntity(resourceUri, CurrentWeather.class);

        } catch (HttpClientErrorException e) {
            throw new CityNotFoundException("The city " + city + " is not found");
        }

        return currentWeatherResponseEntity.getBody();
    }

}
