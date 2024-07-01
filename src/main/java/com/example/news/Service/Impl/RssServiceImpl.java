package com.example.news.Service.Impl;

import com.example.news.Entity.Rss;
import com.example.news.Repository.RssRepository;
import com.example.news.Service.RssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RssServiceImpl implements RssService {

    @Autowired
    private RssRepository rssRepository;

    @Override
    public Rss save(Rss rss) {
        return rssRepository.save(rss);
    }

    @Override
    public List<Rss> getAllRssFeeds() {
        return rssRepository.findAll();
    }
}
