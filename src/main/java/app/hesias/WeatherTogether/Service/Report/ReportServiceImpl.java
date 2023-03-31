package app.hesias.WeatherTogether.Service.Report;

import app.hesias.WeatherTogether.Model.Report;
import app.hesias.WeatherTogether.Repository.ReportRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ReportServiceImpl implements ReportService {

    @PersistenceContext
    private EntityManager entityManager;
    private ReportRepo reportRepo;

    @Override
    public void createReport(@RequestBody Report report) {
        reportRepo.save(report);
    }

    @Override
    public void createReports(List<Report> reports) {
        reportRepo.saveAll(reports);
    }

    @Override
    public List<Report> getReports() {
        return reportRepo.findAll();
    }

    @Override
    public List<Report> getReportsByUsername(String username) {
        return reportRepo.getReportsByUsername(username);
    }

    @Override
    public List<Report> getReportsByRadius(double latitude, double longitude, double radius) {
        return reportRepo.findAll().stream().filter(r -> {
            double distance = distance(latitude, longitude, r.getLatitude(), r.getLongitude());
            return distance <= radius;
        }).toList();
    }

    @Override
    public List<Report> getReportsOrderByTemp() {
        return reportRepo.getReportsOrderByTemp();
    }

    @Override
    public Report getReportById(@PathVariable int id) {
        return reportRepo.findById(id).orElse(null);
    }

    @Override
    public Report updateReport(@PathVariable int id, @RequestBody Report report) {
        return reportRepo.findById(id).map(r -> {
            r.setDateReport(LocalDateTime.now());
            r.setLatitude(report.getLatitude());
            r.setLongitude(report.getLongitude());
            r.setTemperature(report.getTemperature());
            r.setWeather(report.getWeather());
            return reportRepo.save(r);
        }).orElse(null);
    }

    @Override
    public void deleteReport(@PathVariable int id) {
        reportRepo.deleteById(id);
    }

    @Override
    public long getReportCount() {
        return reportRepo.count();
    }

    private double distance(double lat1, double lon1, double lat2, double lon2) {
        final int EARTH_RADIUS = 6371;
        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);

        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return EARTH_RADIUS * c;
    }
}