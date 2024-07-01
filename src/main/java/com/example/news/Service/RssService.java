package com.example.news.Service;

import com.example.news.Entity.Rss;

import java.util.List;

public interface RssService {
    Rss save(Rss rss);
    List<Rss> getAllRssFeeds();

}
