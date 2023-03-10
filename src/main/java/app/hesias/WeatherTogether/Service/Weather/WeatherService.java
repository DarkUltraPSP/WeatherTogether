package app.hesias.WeatherTogether.Service.Weather;

import app.hesias.WeatherTogether.Model.Weather;

import java.util.List;

public interface WeatherService {
    void createWeather(Weather weather);
    void createWeathers(List<Weather> weathers);
    List<Weather> getWeathers();
    Weather getWeatherById(int id);
    Weather updateWeather(int id, Weather weather);
    void deleteWeather(int id);
}
