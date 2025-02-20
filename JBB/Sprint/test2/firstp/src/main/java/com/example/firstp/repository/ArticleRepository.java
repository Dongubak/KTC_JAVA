package com.example.firstp.repository;

import com.example.firstp.entity.Article;
import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> {
    ArrayList<Article> findAll();
}
