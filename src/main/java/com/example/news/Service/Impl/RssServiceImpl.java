package com.example.news.Service.Impl;

import com.example.news.Entity.Rss;
import com.example.news.Repository.RssRepository;
import com.example.news.Service.RssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RssServiceImpl implements RssService {

    @Autowired
    private RssRepository rssRepository;

    @Override
    public Rss save(Rss rss) {
        return rssRepository.save(rss);
    }

    @Override
    public void deleteById(Long id) {
        rssRepository.deleteById(id);
    }

    @Override
    public Optional<Rss> getRssById(Long id) {
        return rssRepository.findById(id);
    }


    @Override
    public Rss update(Long id, Rss updatedRss) {
        Optional<Rss> optionalUser = rssRepository.findById(id);
        if (optionalUser.isPresent()) {
            Rss rss = optionalUser.get();
            rss.setLink(updatedRss.getLink());
            rss.setCategory(updatedRss.getCategory());
            return rssRepository.save(rss);
        }
        return null;
    }

    @Override
    public List<Rss> getAllRssFeeds() {
        return rssRepository.findAll();
    }
}
