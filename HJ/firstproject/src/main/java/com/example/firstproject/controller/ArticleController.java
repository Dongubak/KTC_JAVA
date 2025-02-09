package com.example.firstproject.controller;


import com.example.firstproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;


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

   @PostMapping("/articles/create")
   public String createArticles(ArticleForm form) {
      System.out.println(form.toString());
      Article article = form.toEntity(); // entity 변환

      System.out.println(article.toString());
      Article saved = articleRepository.save(article);
      /// repository를 이용해 db에 저장¡한 뒤 saved객체 반환함
      System.out.println(saved.toString());

      return "";
   }

   @GetMapping("articles/{id}")
   public String show(@PathVariable Long id, Model model) {
      log.info("id : " + id);
      Article articleEntity = articleRepository.findById(id).orElse(null);
      model.addAttribute("article", articleEntity);

      return "articles/show";
   }

   @GetMapping("articles")
   public String index(Model model) {
      ArrayList<Article> articleEntityList = articleRepository.findAll();
      model.addAttribute("articleList", articleEntityList);

      return "articles/index";
   }
}
