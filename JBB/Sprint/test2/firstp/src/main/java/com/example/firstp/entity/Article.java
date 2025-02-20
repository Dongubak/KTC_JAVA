package com.example.firstp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Article {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @Column
    private String title;
    @Column
    private String content;

    public void patch(Article article) {
        if (article.title != null) {
            this.title = article.title;
        }

        if (article.content != null) {
            this.content = article.content;
        }

    }

    public Article(final Long id, final String title, final String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Article() {
    }

    public String toString() {
        Long var10000 = this.getId();
        return "Article(id=" + var10000 + ", title=" + this.getTitle() + ", content=" + this.getContent() + ")";
    }

    public Long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getContent() {
        return this.content;
    }
}
