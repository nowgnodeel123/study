package com.nowgnodeel.studyspringboot.comment.entity;

import com.nowgnodeel.studyspringboot.board.entity.Board;
import com.nowgnodeel.studyspringboot.comment.dto.CreateCommentRequestDto;
import com.nowgnodeel.studyspringboot.global.entity.Timestamped;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Comment extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "board_id", nullable = false)
    private Board board;

    public static Comment toEntity(CreateCommentRequestDto requestDto) {
        return Comment.builder()
                .content(requestDto.content())
                .build();
    }
}
