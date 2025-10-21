package com.nowgnodeel.studyspringboot.board.controller;

import com.nowgnodeel.studyspringboot.board.dto.*;
import com.nowgnodeel.studyspringboot.board.entity.Board;
import com.nowgnodeel.studyspringboot.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/boards/write")
    public ResponseEntity<CreateBoardResponseDto> createBoard(@RequestBody CreateBoardRequestDto requestDto) {
        Board board = boardService.createBoard(requestDto);
        CreateBoardResponseDto responseDto = CreateBoardResponseDto.toDto(board);
        URI location = URI.create("/api/boards/" + board.getId());
        return ResponseEntity.created(location).body(responseDto);
    }

    @DeleteMapping("/boards/{boardId}")
    public ResponseEntity<Void> deleteBoard(@PathVariable Long boardId) {
        boardService.deleteBoard(boardId);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/boards/{boardId}/modify")
    public ResponseEntity<ModifyBoardResponseDto> modifyBoard(@PathVariable Long boardId, @RequestBody ModifyBoardRequestDto requestDto) {
        Board board = boardService.modifyBoard(boardId, requestDto);
        ModifyBoardResponseDto responseDto = ModifyBoardResponseDto.toDto(board);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/boards")
    public ResponseEntity<Page<GetBoardListResponseDto>> getBoardList(@PageableDefault Pageable pageable) {
        Page<Board> boardList = boardService.getBoardList(pageable);
        Page<GetBoardListResponseDto> responseDto = GetBoardListResponseDto.toDto(boardList);
        return ResponseEntity.ok(responseDto);
    }
}
