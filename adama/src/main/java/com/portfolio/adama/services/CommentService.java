package com.portfolio.adama.services;

import com.portfolio.adama.entities.Comment;
import com.portfolio.adama.repositories.CommentRepository;
import com.portfolio.adama.requests.CommentRequest;
import com.portfolio.adama.responses.CommentResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    public CommentService(CommentRepository commentRepository, CommentMapper commentMapper) {
        this.commentRepository = commentRepository;
        this.commentMapper = commentMapper;
    }

    public Comment create(CommentRequest commentRequest) {
        Comment comment = this.commentMapper.fromRequestToComment(commentRequest);
        return this.commentRepository.save(comment);
    }

    public List<CommentResponse> getAll() {
        return this.commentRepository.findAll()
                .stream()
                .map(this.commentMapper::fromCommentToResponse)
                .toList();
    }

    public CommentResponse getById(Long id){
        return this.commentMapper.fromCommentToResponse(this.commentRepository.findById(id).orElse(null));
    }
}
