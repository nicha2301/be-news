package com.example.news.Service;

import com.example.news.Entity.Report;

import java.util.List;

public interface ReportService {

    Report save(Report report);

    List<Report> getAllReports();
}
