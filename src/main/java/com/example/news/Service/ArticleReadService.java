package com.example.news.Service;


import com.example.news.Entity.ArticleRead;

import java.util.List;

public interface ArticleReadService {
    ArticleRead save(ArticleRead articleRead);
    List<ArticleRead> findAllByUserId(Long userId);

    List<ArticleRead> getAllAriticleRead();
}