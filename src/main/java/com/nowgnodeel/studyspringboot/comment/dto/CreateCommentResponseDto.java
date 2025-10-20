package com.nowgnodeel.studyspringboot.comment.dto;

import com.nowgnodeel.studyspringboot.comment.entity.Comment;

public record CreateCommentResponseDto(
        String content
) {
    public static CreateCommentResponseDto toDto(Comment comment) {
        return new CreateCommentResponseDto(
                comment.getContent()
        );
    }
}
