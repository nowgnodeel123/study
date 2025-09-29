package com.nowgnodeel.studyspringboot.board.dto;

import com.nowgnodeel.studyspringboot.board.entity.Board;

public record ModifyBoardResponseDto(
        String title,
        String content
) {
    public static ModifyBoardResponseDto toDto(Board board) {
        return new ModifyBoardResponseDto(
                board.getTitle(),
                board.getContent()
        );
    }
}
