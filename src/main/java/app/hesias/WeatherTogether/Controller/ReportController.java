package app.hesias.WeatherTogether.Controller;

import app.hesias.WeatherTogether.Model.Report;
import app.hesias.WeatherTogether.Service.Report.ReportService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/report")
@AllArgsConstructor
public class ReportController {
    private final ReportService reportService;

    @GetMapping
    public List<Report> getAllReports() {
        return reportService.getReports();
    }

    @GetMapping("/user/{username}")
    public List<Report> getReportsByUsername(@PathVariable String username) {
        return reportService.getReportsByUsername(username);
    }

    @GetMapping("/radius/{latitude}/{longitude}/{radius}")
    public List<Report> getReportsByRadius(@PathVariable double latitude, @PathVariable double longitude, @PathVariable double radius) {
        return reportService.getReportsByRadius(latitude, longitude, radius);
    }

    @GetMapping("/temp")
    public List<Report> getReportsOrderByTemp() {
        return reportService.getReportsOrderByTemp();
    }

    @PostMapping
    public void createReport(@RequestBody Report report) {
        reportService.createReport(report);
    }

    @PostMapping("/list")
    public void createReports(@RequestBody List<Report> reports) {
        reportService.createReports(reports);
    }

    @PutMapping("/{id}")
    public Report updateReport(@PathVariable int id, @RequestBody Report report) {
        return reportService.updateReport(id, report);
    }

    @DeleteMapping("/{id}")
    public void deleteReport(@PathVariable int id) {
        reportService.deleteReport(id);
    }

}
