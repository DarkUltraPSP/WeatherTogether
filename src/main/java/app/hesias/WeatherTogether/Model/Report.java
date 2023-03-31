package app.hesias.WeatherTogether.Model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "Report")
@Getter
@Setter
@NoArgsConstructor
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "report_id", nullable = false)
    private int id;
    private LocalDateTime dateReport;
    private double latitude;
    private double longitude;
    private double temperature;
    @ManyToOne
    @JoinColumn(name = "weather_id")
    private Weather weather;
    private String username;

    @Builder
    public Report(LocalDateTime dateReport, double latitude, double longitude, double temperature, Weather weather, String username) {
        this.dateReport = dateReport;
        this.latitude = latitude;
        this.longitude = longitude;
        this.temperature = temperature;
        this.weather = weather;
        this.username = username;
    }
}
