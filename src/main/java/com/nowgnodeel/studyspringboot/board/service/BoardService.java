package com.nowgnodeel.studyspringboot.board.service;

import com.nowgnodeel.studyspringboot.board.dto.CreateBoardRequestDto;
import com.nowgnodeel.studyspringboot.board.entity.Board;
import com.nowgnodeel.studyspringboot.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public Board createBoard(CreateBoardRequestDto requestDto) {
        Board board = Board.toEntity(requestDto);
        return boardRepository.save(board);
    }
}
