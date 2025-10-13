package com.nowgnodeel.studyspringboot.board.service;

import com.nowgnodeel.studyspringboot.board.dto.CreateBoardRequestDto;
import com.nowgnodeel.studyspringboot.board.dto.ModifyBoardRequestDto;
import com.nowgnodeel.studyspringboot.board.entity.Board;
import com.nowgnodeel.studyspringboot.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public Board createBoard(CreateBoardRequestDto requestDto) {
        Board board = Board.toEntity(requestDto);
        return boardRepository.save(board);
    }

    @Transactional
    public void deleteBoard(Long boardId) {
        if (!boardRepository.existsById(boardId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Board not found");
        }
        boardRepository.deleteById(boardId);
    }

    @Transactional
    public Board modifyBoard(Long boardId, ModifyBoardRequestDto requestDto) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Board not found"));
        board.patch(requestDto);
        return boardRepository.save(board);
    }

    @Transactional
    public Page<Board> getBoardList(Pageable pageable) {
        if (boardRepository.findAll(pageable).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Board not found");
        }
        return boardRepository.findAll(pageable);
    }
}
