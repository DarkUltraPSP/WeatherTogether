package app.hesias.WeatherTogether.Repository;

import app.hesias.WeatherTogether.Model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepo extends JpaRepository<Report, Integer> {
    @Query("SELECT r FROM Report r ORDER BY r.dateReport DESC")
    List<Report> findAll();

    @Query("SELECT r from Report r where r.username = :username")
    List<Report> getReportsByUsername(@Param("username") String username);

    @Query("SELECT r from Report r order by r.temperature desc")
    List<Report> getReportsOrderByTemp();
}
