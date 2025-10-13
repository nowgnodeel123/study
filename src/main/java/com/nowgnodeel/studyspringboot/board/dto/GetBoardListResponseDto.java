package com.nowgnodeel.studyspringboot.board.dto;

import com.nowgnodeel.studyspringboot.board.entity.Board;
import com.nowgnodeel.studyspringboot.board.entity.Category;
import org.springframework.data.domain.Page;

public record GetBoardListResponseDto(
        String title,
        String content,
        Category category
) {
    public static Page<GetBoardListResponseDto> toDto(Page<Board> board) {
        return board.map(v -> new GetBoardListResponseDto(
                v.getTitle(),
                v.getContent(),
                v.getCategory()
        ));
    }
}
