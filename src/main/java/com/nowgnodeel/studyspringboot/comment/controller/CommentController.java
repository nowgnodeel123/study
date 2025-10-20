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
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/{boardId}")
    public ResponseEntity<CreateCommentResponseDto> createComment(@PathVariable("boardId") Long boardId, @RequestBody CreateCommentRequestDto requestDto) {
        Comment comment = commentService.createComment(boardId, requestDto);
        CreateCommentResponseDto responseDto = CreateCommentResponseDto.toDto(comment);
        URI location = URI.create("/comments/" + comment.getId());
        return ResponseEntity.created(location).body(responseDto);
    }
}
