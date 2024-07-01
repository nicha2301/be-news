package com.example.news.Service.Impl;

import com.example.news.Entity.Report;
import com.example.news.Entity.Rss;
import com.example.news.Repository.ReportRepository;
import com.example.news.Service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportRepository reportRepository;


    @Override
    public Report save(Report report) {
        return reportRepository.save(report);
    }

    @Override
    public Optional<Report> findReportById(Long id) {
        return reportRepository.findById(id);
    }

    @Override
    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    @Override
    public Report update(Long id, Report updatedReport) {
        Optional<Report> optionalReport = reportRepository.findById(id);
        if (optionalReport.isPresent()) {
            Report report = optionalReport.get();
            report.setNameArticle(updatedReport.getNameArticle());
            report.setDescription(updatedReport.getNameArticle());
            return reportRepository.save(report);
        }
        return null;
    }
}
