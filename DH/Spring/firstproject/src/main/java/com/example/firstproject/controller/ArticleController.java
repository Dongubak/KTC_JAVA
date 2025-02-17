package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;

@Slf4j
@Controller
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleForm() {
        return "articles/new";
    }

    @PostMapping("/articles/new")
    public String createArticle(ArticleForm form) {
        log.info(form.toString());
        // System.out.println(form.toString());

        Article article = form.toEntity();
        log.info(article.toString());
        // System.out.println(article.toString());

        Article saved = articleRepository.save(article);
        log.info(saved.toString());
        // System.out.println(saved.toString());

        return "redirect:/articles/" + saved.getId();
    }

    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model){
        log.info("id = " + id);

        //데이터 가져오고
        Article articleEntity = articleRepository.findById(id).orElse(null);
        //Optional<Article> articleEntity = articleRepository.findById(id);
        //데이터 등록하고
        model.addAttribute("article", articleEntity);
        //뷰 페이지 반환하고
        return "articles/show";
    }

    @GetMapping("/articles")
    public String index(Model model){
        //모든데이터 가져오고
        ArrayList<Article> articleEntityList = articleRepository.findAll();
        //데이터 등록하고
        model.addAttribute("articleList", articleEntityList);
        //설정하고
        return "articles/index";
    }

    @GetMapping("/articles/{id}/edit")
    public String edit(@PathVariable Long id, Model model){
        //데이터 가져오고
        Article articleEntity = articleRepository.findById(id).orElse(null);
        //데이터 등록하고
        model.addAttribute("article", articleEntity);
        return "articles/edit";
    }

    @PostMapping("/articles/update")
    public String update(ArticleForm form, Model model){
        log.info(form.toString());

        Article articleEntity = form.toEntity();
        log.info(articleEntity.toString());

        Article target = articleRepository.findById(articleEntity.getId()).orElse(null);

        if(target != null){
            articleRepository.save(articleEntity);
        }
        //뷰 페이지 반환하고
        return "redirect:/articles/" + articleEntity.getId();
    }
    @GetMapping("/articles/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes rttr){
        log.info("삭제 요청이 들어왔습니다.");

        Article target = articleRepository.findById(id).orElse(null);
        log.info(target.toString());

        if(target != null){
            articleRepository.delete(target);
            rttr.addFlashAttribute("msg", "삭제됐습니다!");
        }
        return "redirect:/articles";
    }
}
