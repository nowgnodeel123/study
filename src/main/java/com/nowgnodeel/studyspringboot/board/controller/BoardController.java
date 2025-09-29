package com.nowgnodeel.studyspringboot.board.controller;

import com.nowgnodeel.studyspringboot.board.dto.CreateBoardRequestDto;
import com.nowgnodeel.studyspringboot.board.dto.CreateBoardResponseDto;
import com.nowgnodeel.studyspringboot.board.entity.Board;
import com.nowgnodeel.studyspringboot.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/boards")
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/write")
    public ResponseEntity<CreateBoardResponseDto> createBoard(@RequestBody CreateBoardRequestDto requestDto) {
        Board board = boardService.createBoard(requestDto);
        CreateBoardResponseDto responseDto = CreateBoardResponseDto.toDto(board);
        URI location = URI.create("/boards/" + board.getId());
        return ResponseEntity.created(location).body(responseDto);
    }

    @DeleteMapping("/{boardId}")
    public ResponseEntity<Void> deleteBoard(@PathVariable Long boardId) {
        boardService.deleteBoard(boardId);
        return ResponseEntity.noContent().build();
    }
}
