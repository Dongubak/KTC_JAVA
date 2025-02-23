package com.example.firstp.api;

import com.example.firstp.dto.ArticleForm;
import com.example.firstp.entity.Article;
import com.example.firstp.service.ArticleService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleApiController {
    private static final Logger log = LoggerFactory.getLogger(ArticleApiController.class);
    @Autowired
    private ArticleService articleService;

    public ArticleApiController() {
    }

    @GetMapping({"/api/articles"})
    public List<Article> index() {
        return this.articleService.index();
    }

    @GetMapping({"/api/articles/{id}"})
    public Article show(@PathVariable Long id) {
        return this.articleService.show(id);
    }

    @PostMapping({"/api/articles"})
    public ResponseEntity<Article> create(@RequestBody ArticleForm dto) {
        Article created = this.articleService.create(dto);
        return created != null ? ResponseEntity.status(HttpStatus.OK).body(created) : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PatchMapping({"/api/articles/{id}"})
    public ResponseEntity<Article> update(@PathVariable Long id, @RequestBody ArticleForm dto) {
        Article updated = this.articleService.update(id, dto);
        return updated != null ? ResponseEntity.status(HttpStatus.OK).body(updated) : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @DeleteMapping({"/api/articles/{id}"})
    public ResponseEntity<Article> delete(@PathVariable Long id) {
        Article deleted = this.articleService.delete(id);
        return deleted != null ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PostMapping({"/api/transaction-test"})
    public ResponseEntity<List<Article>> transactionTest(@RequestBody List<ArticleForm> dtos) {
        List<Article> createdList = this.articleService.createArticles(dtos);
        return createdList != null ? ResponseEntity.status(HttpStatus.OK).body(createdList) : ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
