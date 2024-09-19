package com.portfolio.adama.services;

import com.portfolio.adama.entities.Comment;
import com.portfolio.adama.requests.CommentRequest;
import com.portfolio.adama.responses.CommentResponse;
import org.springframework.stereotype.Service;

@Service
public class CommentMapper {
    public Comment fromRequestToComment(CommentRequest request){
        return Comment.builder()
                .subject(request.subject())
                .email(request.email())
                .body(request.body())
                .build();
    }

    public CommentResponse fromCommentToResponse(Comment comment){
        if (comment == null) {
            return null;
        }
        return new CommentResponse(
                comment.getId(),
                comment.getEmail(),
                comment.getSubject(),
                comment.getBody()
        );
    }
}
