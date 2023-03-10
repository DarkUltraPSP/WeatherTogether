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
    public List<Report> getAllUsers() {
        return reportService.getReports();
    }

    @GetMapping("/{id}")
    public Report getReportById(@PathVariable int id) {
        return reportService.getReportById(id);
    }

    @GetMapping("/count")
    public long getReportCount() {
        return reportService.getReportCount();
    }

    @PostMapping
    public void createReport(@RequestBody Report report) {
        reportService.createReport(report);
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
