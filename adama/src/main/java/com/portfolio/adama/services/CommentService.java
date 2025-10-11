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
    private final MailService mailService;

    public CommentService(CommentRepository commentRepository, CommentMapper commentMapper, MailService mailService) {
        this.mailService = mailService;
        this.commentRepository = commentRepository;
        this.commentMapper = commentMapper;
    }

    public CommentResponse create(CommentRequest commentRequest) {
        Comment comment = this.commentMapper.fromRequestToComment(commentRequest);
        this.commentRepository.save(comment);

        MailService.Mail mail = new MailService.Mail("tuoadama17@gmail.com","Commentaire réçu",
                "Sujet: " + comment.getSubject() + "\n" +
                "Email: " + comment.getEmail() + "\n" +
                "Message: " + comment.getBody() + "\n"
        );
        this.mailService.sendEmail(mail);
        return this.commentMapper.fromCommentToResponse(comment);
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
