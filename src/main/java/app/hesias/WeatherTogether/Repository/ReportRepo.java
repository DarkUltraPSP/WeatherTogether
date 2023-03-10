package app.hesias.WeatherTogether.Repository;

import app.hesias.WeatherTogether.Model.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepo extends JpaRepository<Report, Integer> {
}
