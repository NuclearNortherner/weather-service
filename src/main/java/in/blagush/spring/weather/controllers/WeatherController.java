package in.blagush.spring.weather.controllers;

import in.blagush.spring.weather.beans.CurrentWeather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/")
@PropertySource(value= {"classpath:application.properties"})
public class WeatherController {

    @Autowired
    private Environment environment;

    @GetMapping("")
    public String getCurrentWeatherForGomel(Model model) {

        RestTemplate restTemplate = new RestTemplate();
        String resourceUri = environment.getProperty("weather.server.url") + "?q=Homyel&units=metric&appid=" +
                environment.getProperty("weather.server.appid");
        System.out.println(resourceUri);
        ResponseEntity<CurrentWeather> currentWeatherResponseEntity
                = restTemplate.getForEntity(resourceUri, CurrentWeather.class);

        model.addAttribute("currentWeather", currentWeatherResponseEntity.getBody());

        return "weather";
    }

    @GetMapping("/{city}")
    public String getCurrentWeather(@PathVariable String city, Model model) {

        if ("Gomel".equals(city)) {
            city = "Homyel";
        }

        RestTemplate restTemplate = new RestTemplate();

        String resourceUri = environment.getProperty("weather.server.url") + "?q=" + city + "&units=metric&appid=" +
                environment.getProperty("weather.server.appid");

        try {
            ResponseEntity<CurrentWeather> currentWeatherResponseEntity
                    = restTemplate.getForEntity(resourceUri, CurrentWeather.class);

            model.addAttribute("currentWeather", currentWeatherResponseEntity.getBody());

        } catch (HttpClientErrorException e) {
            model.addAttribute("city", city);
            return "error";
        }

        return "weather";
    }

}
