package app.hesias.WeatherTogether.Service.Report;

import app.hesias.WeatherTogether.Model.Report;

import java.util.List;

public interface ReportService {
    void createReport(Report report);
    List<Report> getReports();
    Report getReportById(int id);
    Report updateReport(int id, Report report);
    void deleteReport(int id);
    long getReportCount();
}
