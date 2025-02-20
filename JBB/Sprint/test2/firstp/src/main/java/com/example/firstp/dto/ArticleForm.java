package com.example.firstp.dto;

import com.example.firstp.entity.Article;

public class ArticleForm {
    private Long id;
    private String title;
    private String content;

    public Article toEntity() {
        return new Article(this.id, this.title, this.content);
    }

    public ArticleForm(final Long id, final String title, final String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public String toString() {
        return "ArticleForm(id=" + this.id + ", title=" + this.title + ", content=" + this.content + ")";
    }
}
