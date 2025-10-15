package com.nowgnodeel.studyspringboot.board.entity;

import com.nowgnodeel.studyspringboot.board.dto.CreateBoardRequestDto;
import com.nowgnodeel.studyspringboot.board.dto.ModifyBoardRequestDto;
import com.nowgnodeel.studyspringboot.comment.entity.Comment;
import com.nowgnodeel.studyspringboot.global.entity.Timestamped;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Board extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Category category;

    @OneToMany(mappedBy = "board")
    private List<Comment> comments = new ArrayList<>();

    public static Board toEntity(CreateBoardRequestDto requestDto) {
        return Board.builder()
                .title(requestDto.title())
                .content(requestDto.content())
                .category(requestDto.category())
                .build();
    }

    public void patch(ModifyBoardRequestDto requestDto) {
        this.title = requestDto.title();
        this.content = requestDto.content();
        this.category = requestDto.category();
    }
}
