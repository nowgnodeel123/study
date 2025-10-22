package com.nowgnodeel.studyspringboot.comment.controller;

import com.nowgnodeel.studyspringboot.comment.dto.CreateCommentRequestDto;
import com.nowgnodeel.studyspringboot.comment.dto.CreateCommentResponseDto;
import com.nowgnodeel.studyspringboot.comment.entity.Comment;
import com.nowgnodeel.studyspringboot.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/boards/{boardId}/comments")
    public ResponseEntity<CreateCommentResponseDto> createComment(@PathVariable("boardId") Long boardId, @RequestBody CreateCommentRequestDto requestDto) {
        Comment comment = commentService.createComment(boardId, requestDto);
        CreateCommentResponseDto responseDto = CreateCommentResponseDto.toDto(comment);
        URI location = URI.create(String.format("/api/boards/%d/comments/%d", boardId, comment.getId()));
        return ResponseEntity.created(location).body(responseDto);
    }

    @DeleteMapping("/boards/{boardId}/comments/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable("boardId") Long boardId, @PathVariable("commentId") Long commentId) {
        commentService.deleteComment(boardId, commentId);
        return ResponseEntity.noContent().build();
    }
}
