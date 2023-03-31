package app.hesias.WeatherTogether;

import app.hesias.WeatherTogether.Model.Weather;
import app.hesias.WeatherTogether.Repository.WeatherRepo;
import app.hesias.WeatherTogether.Service.Weather.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class WeatherTogetherApplication{

	public static void main(String[] args) {
		SpringApplication.run(WeatherTogetherApplication.class, args);
	}
}
