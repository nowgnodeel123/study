package com.nowgnodeel.studyspringboot.board.dto;

import com.nowgnodeel.studyspringboot.board.entity.Category;

public record ModifyBoardRequestDto(
        String title,
        String content,
        Category category
) {
}
