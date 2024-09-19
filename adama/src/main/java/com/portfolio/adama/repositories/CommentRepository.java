package com.portfolio.adama.repositories;

import com.portfolio.adama.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
