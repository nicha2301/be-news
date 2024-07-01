package com.example.news.Repository;

import com.example.news.Entity.Rss;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RssRepository extends JpaRepository<Rss, Long> {
}
