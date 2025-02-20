package com.example.firstp.api;

import com.example.firstp.dto.CommentDto;
import com.example.firstp.service.CommentService;
import java.util.List;
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
public class CommentApiController {
    @Autowired
    private CommentService commentService;

    public CommentApiController() {
    }

    @GetMapping({"/api/articles/{articleId}/comments"})
    public ResponseEntity<List<CommentDto>> comments(@PathVariable Long articleId) {
        List<CommentDto> dtos = this.commentService.comments(articleId);
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }

    @PostMapping({"/api/articles/{articleId}/comments"})
    public ResponseEntity<CommentDto> create(@PathVariable Long articleId, @RequestBody CommentDto dto) {
        CommentDto createdDto = this.commentService.create(articleId, dto);
        return ResponseEntity.status(HttpStatus.OK).body(createdDto);
    }

    @PatchMapping({"/api/comments/{id}"})
    public ResponseEntity<CommentDto> update(@PathVariable Long id, @RequestBody CommentDto dto) {
        CommentDto updatedDto = this.commentService.update(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(updatedDto);
    }

    @DeleteMapping({"/api/comments/{id}"})
    public ResponseEntity<CommentDto> delete(@PathVariable Long id) {
        CommentDto deletedDto = this.commentService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(deletedDto);
    }
}