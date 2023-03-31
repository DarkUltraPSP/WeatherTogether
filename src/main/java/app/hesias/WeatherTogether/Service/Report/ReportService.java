package app.hesias.WeatherTogether.Service.Report;

import app.hesias.WeatherTogether.Model.Report;

import java.util.List;

public interface ReportService {
    void createReport(Report report);
    void createReports(List<Report> reports);
    List<Report> getReports();
    List<Report> getReportsByUsername(String username);
    List<Report> getReportsByRadius(double latitude, double longitude, double radius);
    List<Report> getReportsOrderByTemp();
    Report getReportById(int id);
    Report updateReport(int id, Report report);
    void deleteReport(int id);
    long getReportCount();
}
