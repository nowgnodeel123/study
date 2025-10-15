package com.nowgnodeel.studyspringboot.comment.repository;

import com.nowgnodeel.studyspringboot.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
