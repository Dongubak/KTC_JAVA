package com.example.firstp.repository;

import com.example.firstp.entity.Comment;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query(
            value = "SELECT * FROM comment WHERE article_id = :articleId",
            nativeQuery = true
    )
    List<Comment> findByArticleId(Long articleId);

    List<Comment> findByNickname(String nickname);
}
