package app.hesias.WeatherTogether.Service.Weather;

import app.hesias.WeatherTogether.Model.Weather;
import app.hesias.WeatherTogether.Repository.WeatherRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@AllArgsConstructor
public class WeatherServiceImpl implements WeatherService{
    private final WeatherRepo weatherRepo;

    @Override
    public void createWeather(@RequestBody Weather weather) {
        System.out.println(weather.getWeather());
        weatherRepo.save(weather);
    }

    @Override
    public void createWeathers(List<Weather> weathers) {
        weatherRepo.saveAll(weathers);
    }

    @Override
    public List<Weather> getWeathers() {
        return weatherRepo.findAll();
    }

    @Override
    public Weather getWeatherById(@PathVariable int id) {
        return weatherRepo.findById(id).orElse(null);
    }

    @Override
    public Weather updateWeather(@PathVariable int id, @RequestBody Weather weather) {
        return weatherRepo.findById(id).map(w -> {
            w.setWeather(weather.getWeather());
            return weatherRepo.save(w);
        }).orElse(null);
    }

    @Override
    public void deleteWeather(@PathVariable int id) {
        weatherRepo.deleteById(id);
    }
}
