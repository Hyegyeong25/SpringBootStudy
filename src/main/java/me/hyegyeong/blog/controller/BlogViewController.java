package me.hyegyeong.blog.controller;

import lombok.RequiredArgsConstructor;
import me.hyegyeong.blog.domain.Article;
import me.hyegyeong.blog.dto.ArticleListViewResponse;
import me.hyegyeong.blog.dto.ArticleViewResponse;
import me.hyegyeong.blog.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class BlogViewController {
    private final BlogService blogService;

    @GetMapping("/articles")
    public String getArticles(Model model){
        List<ArticleListViewResponse> articles = blogService.findAll().stream()
                .map(ArticleListViewResponse::new)
                .toList();

        model.addAttribute("articles", articles); //블로그 글 리스트 저장
        return "articleList"; // articleList.html라는 뷰 조회
    }

    @GetMapping("/articles/{id}")
    public String getArticle(@PathVariable Long id, Model model){
        Article article = blogService.findById(id); //서비스의 findById 함수에 id 인자를 넘겨 값이 있는지 찾는다.
        model.addAttribute("article", new ArticleViewResponse(article)); // 값을 모델로 넘겨 화면에서 사용할 수 있게 한다.

        return "article";
    }

    @GetMapping("/new-article")
    public String newArticle(@RequestParam(required=false) Long id, Model model){
        if(id == null) { //id가 없으면 생성
            model.addAttribute("article", new ArticleViewResponse());
        } else {
            Article article = blogService.findById(id);
            model.addAttribute("article", new ArticleViewResponse(article));
        }
        return "newArticle";
    }
}
