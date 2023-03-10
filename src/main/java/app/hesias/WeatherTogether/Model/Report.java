package app.hesias.WeatherTogether.Model;

import jakarta.persistence.*;
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
}
