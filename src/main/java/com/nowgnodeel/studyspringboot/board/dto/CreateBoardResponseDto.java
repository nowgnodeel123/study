package com.nowgnodeel.studyspringboot.board.dto;

import com.nowgnodeel.studyspringboot.board.entity.Board;
import com.nowgnodeel.studyspringboot.board.entity.Category;

public record CreateBoardResponseDto(
        String title,
        String content,
        Category category
) {
    public static CreateBoardResponseDto toDto(Board board) {
        return new CreateBoardResponseDto(
                board.getTitle(),
                board.getContent(),
                board.getCategory()
        );
    }
}
