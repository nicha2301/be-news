package com.example.news.Service;

import com.example.news.Entity.Rss;

import java.util.List;
import java.util.Optional;

public interface RssService {
    Rss save(Rss rss);
    void deleteById(Long id);
    Rss update(Long id, Rss updatedRss);
    List<Rss> getAllRssFeeds();

    Optional<Rss> getRssById(Long id);
}
