package com.nowgnodeel.studyspringboot.board.dto;

import com.nowgnodeel.studyspringboot.board.entity.Category;

public record CreateBoardRequestDto(
        String title,
        String content,
        Category category
) {
}
