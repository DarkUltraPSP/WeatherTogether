package app.hesias.WeatherTogether.Repository;

import app.hesias.WeatherTogether.Model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherRepo extends JpaRepository<Weather, Integer> {
}