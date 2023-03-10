package app.hesias.WeatherTogether.Service.Report;

import app.hesias.WeatherTogether.Model.Report;
import app.hesias.WeatherTogether.Repository.ReportRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ReportServiceImpl implements ReportService {
    private ReportRepo reportRepo;

    @Override
    public void createReport(@RequestBody Report report) {
        reportRepo.save(report);
    }

    @Override
    public List<Report> getReports() {
        return reportRepo.findAll();
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
}
