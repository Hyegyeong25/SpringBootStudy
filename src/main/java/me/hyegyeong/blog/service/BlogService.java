package me.hyegyeong.blog.service;

import lombok.RequiredArgsConstructor;
import me.hyegyeong.blog.domain.Article;
import me.hyegyeong.blog.dto.AddArticleRequest;
import me.hyegyeong.blog.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor //final이 붙거나 @NotNull이 붙은 필드의 생성자 추가
@Service //빈으로 등록
public class BlogService {
    private final BlogRepository blogRepository;

    // 블로그 글 추가 메서드
    public Article save(AddArticleRequest request){
        return blogRepository.save(request.toEntity());
        // save()메서드는 JpaRepository에서 지원하는 저장 메서드이다.
    }

    public List<Article> findAll() {
        return blogRepository.findAll();
    }

}
