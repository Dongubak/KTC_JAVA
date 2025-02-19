package com.example.firstproject.service;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArticleServiceTest {
    @Autowired
    private ArticleService articleService;

    @Test
    void index() {
        /// 1. 예상 데이터
        /// 2. 실제 데이터
        /// 3. 비교 및 검증

        /// 예상 데이터
        Article a = new Article(1L, "가가가가", "1111");
        Article b = new Article(2L, "나나나나", "2222");
        Article c = new Article(3L, "다다다다", "3333");
        Article d = new Article(4L, "라라라라", "4444");
        List<Article> expected = new ArrayList<Article>(Arrays.asList(a, b, c, d));

        /// 실제 데이터
        List<Article> articles = articleService.index();

        /// 비교 및 검증
        assertEquals(expected.toString(), articles.toString());
    }


    @Test
    void show_성공_존재하는_id_입력() {
        /// 1. 예상 데이터
        /// 2. 실제 데이터
        /// 3. 비교 및 검증

        /// 1. 예상 데이터
        Long id = 1L;
        Article expected = new Article(id, "가가가가", "1111");

        /// 2. 실제 데이터
        Article article = articleService.show(id);

        /// 3. 비교 및 검증
        assertEquals(expected.toString(), article.toString());
    }

    @Test
    void show_실패_존재하지_않는_id_입력() {
        /// 1. 예상 데이터
        Long id = 10L;
        Article expected = null;

        /// 2. 실제 데이터
        Article article = articleService.show(id);

        /// 3. 비교 및 검증
        assertEquals(expected, article);

    }

    @Test
    @Transactional
    void create_성공_title과_content만_있는_dto_입력() {
        /// 1. 예상 데이터
        /// 2. 실제 데이터
        /// 3. 비교 및 검증

        /// 예상 데이터
        String title = "마마마마";
        String content = "5555";

        Article expected = new Article(5L, title, content);

        /// 실제 데이터
        ArticleForm dto = new ArticleForm(null, title, content);
        Article article = articleService.create(dto);

        /// 비교 및 검증
        assertEquals(expected.toString(), article.toString());
    }

    @Test
    @Transactional
    void create_실패_id가_포함된_dto_입력() {
        /// 1. 예상 데이터
        /// 2. 실제 데이터
        /// 3. 비교 및 검증

        /// 예상 데이터
        String title = "마마마마";
        String content = "5555";
        Long id = 5L;

        Article expected = null;

        /// 실제 데이터
        ArticleForm dto = new ArticleForm(id, title, content);
        Article article = articleService.create(dto);

        /// 비교 및 검증
        assertEquals(null, article);
    }

    @Test
    @Transactional
    void update_성공_존재하는_id와_title만_있는_dto_입력() {
        /// 1. 예측 데이터
        /// 2. 실제 데이터
        /// 3. 비교 및 검증

        /// 예측 데이터
        Long id = 1L;
        String title = "수정된 제목";
        String content = "1111";
        Article expected = new Article(id, title, content);

        /// 실제 데이터
        ArticleForm articleForm = new ArticleForm(1L, "수정된 제목", null);
        Article updated = articleService.update(id, articleForm);

        /// 비교 및 검증
        assertEquals(expected.toString(), updated.toString());
    }

    @Test
    @Transactional
    void update_성공_존재하는_id와_title_content가_있는_dto_입력() {
        /// 1. 예측 데이터
        /// 2. 실제 데이터
        /// 3. 비교 및 검증

        /// 예측 데이터
        Long id = 1L;
        String title = "수정된 제목";
        String content = "zzzz";
        ArticleForm articleForm = new ArticleForm(id, title, content);
        Article expected = articleForm.toEntity();

        /// 실제 데이터
        ArticleForm updatedArticleForm = new ArticleForm(1L, "수정된 제목", "zzzz");
        Article updated = articleService.update(id, updatedArticleForm);

        /// 비교 및 검증
        assertEquals(expected.toString(), updated.toString());
    }

    @Test
    @Transactional
    void update_실패_존재하지_않는_id의_dto_입력() {
        /// 1. 예측 데이터
        /// 2. 실제 데이터
        /// 3. 비교 및 검증

        /// 1. 예측 데이터
        /// 2. 실제 데이터
        /// 3. 비교 및 검증

        /// 예측 데이터
        Long id = 10L;
        Article expected = null;

        /// 실제 데이터
        ArticleForm articleForm = new ArticleForm(10L, "수정된 제목", "zzzz");
        Article updated = articleService.update(id, articleForm);

        /// 비교 및 검증
        assertEquals(expected, updated);
    }

    @Test
    @Transactional
    void delete_성공_존재하는_id_입력() {
        /// 1. 예측 데이터
        /// 2. 실제 데이터
        /// 3. 비교 및 검증

        /// 1. 예측 데이터
        ArticleForm articleForm = new ArticleForm(1L, "가가가가", "1111");
        Article expected = articleForm.toEntity();

        /// 2. 실제 데이터
        Article deleted = articleService.delete(1L);

        /// 3. 비교 및 검증
        assertEquals(expected.toString(), deleted.toString());
    }

    @Test
    @Transactional
    void delete_존재하지_않는_id_입력() {
        /// 1. 예측 데이터
        /// 2. 실제 데이터
        /// 3. 비교 및 검증

        /// 예측 데이터
        Article expected = null;

        /// 2. 실제 데이터
        Article deleted = articleService.delete(10L);

        /// 3. 비교 및 검증
        assertEquals(expected, deleted);
    }
}