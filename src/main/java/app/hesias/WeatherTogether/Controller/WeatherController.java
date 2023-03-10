package app.hesias.WeatherTogether.Controller;

import app.hesias.WeatherTogether.Model.Weather;
import app.hesias.WeatherTogether.Service.Weather.WeatherService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/weather")
@AllArgsConstructor
public class WeatherController {
    private final WeatherService weatherService;

    @GetMapping
    public List<Weather> getWeather() {
        return weatherService.getWeathers();
    }

    @GetMapping("/{id}")
    public Weather getWeatherById(@PathVariable int id) {
        return weatherService.getWeatherById(id);
    }

    @PostMapping
    public void createWeather(@RequestBody Weather weather) {
        weatherService.createWeather(weather);
    }

    @PostMapping("/list")
    public void createWeathers(@RequestBody List<Weather> weathers) {
        weatherService.createWeathers(weathers);
    }


    @PutMapping("/{id}")
    public Weather updateWeather(@PathVariable int id, @RequestBody Weather weather) {
        return weatherService.updateWeather(id, weather);
    }

    @DeleteMapping("/{id}")
    public void deleteWeather(@PathVariable int id) {
        weatherService.deleteWeather(id);
    }

}
