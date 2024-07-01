package com.example.news.Controller;


import com.example.news.Entity.Rss;
import com.example.news.Service.RssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRssById(@PathVariable Long id) {
        rssService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Rss>> getRssFeedById(@PathVariable Long id) {
        Optional<Rss> rssFeeds = rssService.getRssById(id);
        return ResponseEntity.ok().body(rssFeeds);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rss> updateRss(@PathVariable Long id, @RequestBody Rss updatedRss) {
        Rss rss = rssService.update(id, updatedRss);
        if (rss != null) {
            return ResponseEntity.ok(rss);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("")
    public ResponseEntity<List<Rss>> getAllRssFeeds() {
        List<Rss> rssFeeds = rssService.getAllRssFeeds();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Range", "users 0-9/" + rssFeeds.size());
        return ResponseEntity.ok().headers(headers).body(rssFeeds);
    }

}