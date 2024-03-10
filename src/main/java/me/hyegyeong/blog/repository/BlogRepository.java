package me.hyegyeong.blog.repository;

import me.hyegyeong.blog.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {
}
