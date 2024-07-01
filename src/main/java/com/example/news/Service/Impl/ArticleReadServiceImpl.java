package com.example.news.Service.Impl;

import com.example.news.Entity.ArticleRead;
import com.example.news.Repository.ArticleReadRepository;
import com.example.news.Service.ArticleReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleReadServiceImpl implements ArticleReadService {

    @Autowired
    private ArticleReadRepository articleReadRepository;

    @Override
    public ArticleRead save(ArticleRead articleRead) {
        return articleReadRepository.save(articleRead);
    }

    @Override
    public List<ArticleRead> findAllByUserId(Long userId) {
        return articleReadRepository.findAllByUserId(userId);
    }

    @Override
    public Optional<ArticleRead> findArticleReadById(Long userId) {
        return articleReadRepository.findById(userId);
    }

    @Override
    public List<ArticleRead> getAllAriticleRead() {
        return articleReadRepository.findAll();
    }

}