package com.example.firstproject.api;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class ArticleApiController {
//    @Autowired
//    private ArticleRepository articleRepository;
//    // GET
//    @GetMapping("/api/articles")
//    public List<Article> index() {
//        return articleRepository.findAll();
//    } check
//
//    @GetMapping("/api/articles/{id}")
//    public Article show(@PathVariable Long id) {
//        return articleRepository.findById(id).orElse(null);
//    }
//    // POST
//    @PostMapping("/api/articles")
//    public Article create(@RequestBody ArticleForm dto) {
//        Article article = dto.toEntity();
//        return articleRepository.save(article);
//    }
//    // PATCH
//    @PatchMapping("api/articles/{id}")
//    public ResponseEntity<Article> update(@PathVariable Long id, @RequestBody ArticleForm dto) {
//        /// 과정
//        /// 1. 수정용 엔티티 생성하기
//        /// 2. DB에 엔티티 있는지 확인하기
//        /// 3. 대상 엔티티가 없거나 수정하려는 id가 잘못됐을 경우 처리하기
//        /// 4. 대상 엔티티가 있으면 수정 내용으로 업데이트하고 정상 응답(200)보내기
//
//        Article article = dto.toEntity();
//        log.info("id: {}, article: {}", id, article.toString());
//
//        Article target = articleRepository.findById(id).orElse(null);
//        if(target == null || !id.equals(article.getId())) {
//            log.info("bad request! id: {}, article: {}", id, article.toString());
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
//        }
//
//        target.patch(article);
//        Article updated = articleRepository.save(target);
//        return ResponseEntity.status(HttpStatus.OK).body(updated);
//    }
//    // DELETE
//    @DeleteMapping("/api/articles/{id}")
//    public ResponseEntity<Article> delete(@PathVariable Long id) {
//        // 1. 대상 찾기
//        // 2. 잘못된 요청 처리하기
//        // 3. 삭제하기
//
//        Article article = articleRepository.findById(id).orElse(null);
//        if(article == null) {
//            log.info("bad request! id: {}, article: {}", id, article.toString());
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
//        }
//        articleRepository.delete(article);
//        return ResponseEntity.status(HttpStatus.OK).body(article);
//    }
    @Autowired
    private ArticleService articleService;

    @GetMapping("/api/articles")
    public List<Article> index() {
        return articleService.index();
    }

    @GetMapping("/api/articles/{id}")
    public Article show(@PathVariable Long id) {
        return articleService.show(id);
    }

    @PostMapping("/api/articles")
    public ResponseEntity<Article> create(@RequestBody ArticleForm dto) {
        Article created = articleService.create(dto);
        return (created != null) ?
                ResponseEntity.status(HttpStatus.OK).body(created) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

//     PATCH
    @PatchMapping("api/articles/{id}")
    public ResponseEntity<Article> update(@PathVariable Long id, @RequestBody ArticleForm dto) {
        /// 과정
        /// 1. 수정용 엔티티 생성하기
        /// 2. DB에 엔티티 있는지 확인하기
        /// 3. 대상 엔티티가 없거나 수정하려는 id가 잘못됐을 경우 처리하기
        /// 4. 대상 엔티티가 있으면 수정 내용으로 업데이트하고 정상 응답(200)보내기

        Article updated = articleService.update(id, dto);

        return (updated != null) ?
                ResponseEntity.status(HttpStatus.OK).body(updated) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    //    // DELETE
    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Article> delete(@PathVariable Long id) {
        // 1. 대상 찾기
        // 2. 잘못된 요청 처리하기
        // 3. 삭제하기

//        Article article = articleRepository.findById(id).orElse(null);
        Article article = articleService.delete(id);

        return (article != null) ?
                ResponseEntity.status(HttpStatus.NO_CONTENT).body(article) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @PostMapping("/api/transaction-test")
    public ResponseEntity<List<Article>> transactionTest
            (@RequestBody List<ArticleForm> dtos) {
        List<Article> createdList = articleService.createArticles(dtos);
        return (createdList != null) ?
                ResponseEntity.status(HttpStatus.OK).body(createdList) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
