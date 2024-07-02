package com.example.news.Controller;

import com.example.news.Entity.Report;
import com.example.news.Entity.Rss;
import com.example.news.Service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/report")
@CrossOrigin(origins = "http://localhost:3000")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @PostMapping("/save")
    public ResponseEntity<Report> saveReport(@RequestBody Report report) {
        Report savedReport = reportService.save(report);
        return ResponseEntity.ok(savedReport);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Report>> findReportById(@PathVariable Long id) {
        Optional<Report> report = reportService.findReportById(id);
        return ResponseEntity.ok().body(report);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Report> updateReport(@PathVariable Long id, @RequestBody Report updatedReport) {
        Report report = reportService.update(id, updatedReport);
        if (report != null) {
            return ResponseEntity.ok(report);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("")
    public ResponseEntity<List<Report>> getAllReports() {
        List<Report> reports = reportService.getAllReports();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Range", "users 0-9/" + reports.size());
        return ResponseEntity.ok().headers(headers).body(reports);
    }

}