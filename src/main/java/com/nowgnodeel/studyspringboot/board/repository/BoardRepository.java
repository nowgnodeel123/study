package com.nowgnodeel.studyspringboot.board.repository;

import com.nowgnodeel.studyspringboot.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
}
