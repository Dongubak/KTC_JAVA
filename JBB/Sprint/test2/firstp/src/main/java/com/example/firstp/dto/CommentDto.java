package com.example.firstp.dto;

import com.example.firstp.entity.Comment;

public class CommentDto {
    private Long id;
    private Long articleId;
    private String nickname;
    private String body;

    public static CommentDto createCommentDto(Comment comment) {
        return new CommentDto(comment.getId(), comment.getArticle().getId(), comment.getNickname(), comment.getBody());
    }

    public CommentDto(final Long id, final Long articleId, final String nickname, final String body) {
        this.id = id;
        this.articleId = articleId;
        this.nickname = nickname;
        this.body = body;
    }

    public CommentDto() {
    }

    public Long getId() {
        return this.id;
    }

    public Long getArticleId() {
        return this.articleId;
    }

    public String getNickname() {
        return this.nickname;
    }

    public String getBody() {
        return this.body;
    }

    public String toString() {
        Long var10000 = this.getId();
        return "CommentDto(id=" + var10000 + ", articleId=" + this.getArticleId() + ", nickname=" + this.getNickname() + ", body=" + this.getBody() + ")";
    }
}
