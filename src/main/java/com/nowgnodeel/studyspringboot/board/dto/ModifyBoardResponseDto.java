package com.nowgnodeel.studyspringboot.board.dto;

import com.nowgnodeel.studyspringboot.board.entity.Board;
import com.nowgnodeel.studyspringboot.board.entity.Category;

public record ModifyBoardResponseDto(
        String title,
        String content,
        Category category
) {
    public static ModifyBoardResponseDto toDto(Board board) {
        return new ModifyBoardResponseDto(
                board.getTitle(),
                board.getContent(),
                board.getCategory()
        );
    }
}
