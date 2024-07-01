package com.example.news.Controller;


import com.example.news.Entity.Rss;
import com.example.news.Service.RssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rss")
@CrossOrigin(origins = "http://localhost:5174")
public class RssController {

    @Autowired
    private RssService rssService;

    @PostMapping("/save")
    public ResponseEntity<Rss> saveRssFeed(@RequestBody Rss rss) {
        Rss savedRss = rssService.save(rss);
        return ResponseEntity.ok(savedRss);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Rss>> getAllRssFeeds() {
        List<Rss> rssFeeds = rssService.getAllRssFeeds();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Range", "users 0-9/" + rssFeeds.size());
        return ResponseEntity.ok().headers(headers).body(rssFeeds);
    }

}