package com.nowgnodeel.studyspringboot.board.dto;

import com.nowgnodeel.studyspringboot.board.entity.Category;

public record GetBoardResponseDto(
        String title,
        String content,
        Category category
) {
}
