package com.example.firstp.entity;

import com.example.firstp.dto.CommentDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Comment {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @ManyToOne
    @JoinColumn(
            name = "article_id"
    )
    private Article article;
    @Column
    private String nickname;
    @Column
    private String body;

    public static Comment createComment(CommentDto dto, Article article) {
        if (dto.getId() != null) {
            throw new IllegalArgumentException("댓글 생성 실패! 댓글의 id가 없어야 합니다.");
        } else if (dto.getArticleId() != article.getId()) {
            throw new IllegalArgumentException("댓글 생성 실패! 게시글의 id가 잘못됐습니다.");
        } else {
            return new Comment(dto.getId(), article, dto.getNickname(), dto.getBody());
        }
    }

    public void patch(CommentDto dto) {
        if (this.id != dto.getId()) {
            throw new IllegalArgumentException("댓글 수정 실패! 잘못된 id가 입력됐습니다.");
        } else {
            if (dto.getNickname() != null) {
                this.nickname = dto.getNickname();
            }

            if (dto.getBody() != null) {
                this.body = dto.getBody();
            }

        }
    }

    public Long getId() {
        return this.id;
    }

    public Article getArticle() {
        return this.article;
    }

    public String getNickname() {
        return this.nickname;
    }

    public String getBody() {
        return this.body;
    }

    public String toString() {
        Long var10000 = this.getId();
        return "Comment(id=" + var10000 + ", article=" + String.valueOf(this.getArticle()) + ", nickname=" + this.getNickname() + ", body=" + this.getBody() + ")";
    }

    public Comment(final Long id, final Article article, final String nickname, final String body) {
        this.id = id;
        this.article = article;
        this.nickname = nickname;
        this.body = body;
    }

    public Comment() {
    }
}
