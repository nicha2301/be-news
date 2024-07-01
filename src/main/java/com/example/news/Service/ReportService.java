package com.example.news.Service;

import com.example.news.Entity.Report;

import java.util.List;
import java.util.Optional;

public interface ReportService {

    Report save(Report report);

    Optional<Report> findReportById(Long id);

    List<Report> getAllReports();

    Report update(Long id, Report updatedReport);
}
