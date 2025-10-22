package com.nowgnodeel.studyspringboot.comment.service;

import com.nowgnodeel.studyspringboot.board.entity.Board;
import com.nowgnodeel.studyspringboot.board.repository.BoardRepository;
import com.nowgnodeel.studyspringboot.comment.dto.CreateCommentRequestDto;
import com.nowgnodeel.studyspringboot.comment.entity.Comment;
import com.nowgnodeel.studyspringboot.comment.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;

    @Transactional
    public Comment createComment(Long boardId, CreateCommentRequestDto requestDto) {
        Board board = boardRepository.findById(boardId).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Board not found"));
        Comment comment = Comment.toEntity(requestDto, board);
        return commentRepository.save(comment);
    }

    @Transactional
    public void deleteComment(Long boardId, Long commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Comment not found"));
        if (!comment.getBoard().getId().equals(boardId)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Comment does not belong to the board");
        }
        commentRepository.delete(comment);
    }
}
