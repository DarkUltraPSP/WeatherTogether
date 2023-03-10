package app.hesias.WeatherTogether.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Weather")
@Getter
@Setter
@NoArgsConstructor
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "weather_id", nullable = false)
    private int id;
    private String weather;
}
