package com.nowgnodeel.studyspringboot.board.dto;

import com.nowgnodeel.studyspringboot.board.entity.Board;

public record CreateBoardResponseDto(
        String title,
        String content
) {
    public static CreateBoardResponseDto toDto(Board board) {
        return new CreateBoardResponseDto(
                board.getTitle(),
                board.getContent()
        );
    }
}
