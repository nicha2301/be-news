package com.example.news.Repository;

import com.example.news.Entity.ArticleRead;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleReadRepository extends JpaRepository<ArticleRead, Long> {
    List<ArticleRead> findAllByUserId(Long userId);
}
