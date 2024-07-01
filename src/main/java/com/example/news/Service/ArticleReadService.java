package com.example.news.Service;


import com.example.news.Entity.ArticleRead;

import java.util.List;
import java.util.Optional;

public interface ArticleReadService {
    ArticleRead save(ArticleRead articleRead);
    List<ArticleRead> findAllByUserId(Long userId);

    Optional<ArticleRead> findArticleReadById(Long userId);

    List<ArticleRead> getAllAriticleRead();
}