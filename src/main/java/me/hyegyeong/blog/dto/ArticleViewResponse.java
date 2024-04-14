package me.hyegyeong.blog.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import me.hyegyeong.blog.domain.Article;

import java.time.LocalDateTime;

@NoArgsConstructor //@NoArgsConstructor는 기본 생성자를 생성해주는 어노테이션
@Getter
public class ArticleViewResponse {
    private Long id;
    private String title;
    private String author;
    private String content;
    private LocalDateTime createdAt;

    public ArticleViewResponse(Article article){
        this.id=article.getId();
        this.title=article.getTitle();
        this.author=article.getAuthor();
        this.content=article.getContent();
        this.createdAt=article.getCreatedAt();
    }

}
