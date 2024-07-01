package com.example.news.Controller;

import com.example.news.Entity.ArticleRead;
import com.example.news.Entity.Report;
import com.example.news.Service.ArticleReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/article-read")
@CrossOrigin(origins = "http://localhost:5174")
public class ArticleReadController {

    @Autowired
    private ArticleReadService articleReadService;

    @PostMapping("/save")
    public ResponseEntity<ArticleRead> saveArticleRead(@RequestBody ArticleRead articleRead) {
        ArticleRead savedArticleRead = articleReadService.save(articleRead);
        return ResponseEntity.ok(savedArticleRead);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ArticleRead>> getAllReadArticlesByUser(@PathVariable Long userId) {
        List<ArticleRead> articlesRead = articleReadService.findAllByUserId(userId);
        return ResponseEntity.ok(articlesRead);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ArticleRead>> getAllReports() {
        List<ArticleRead> read = articleReadService.getAllAriticleRead();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Range", "users 0-9/" + read.size());
        return ResponseEntity.ok().headers(headers).body(read);
    }
}