package com.nowgnodeel.studyspringboot.comment.service;

import com.nowgnodeel.studyspringboot.comment.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
}
