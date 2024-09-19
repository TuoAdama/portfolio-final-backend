package com.portfolio.adama.responses;

public record CommentResponse(
        Long id,
        String email,
        String subject,
        String body
) {
}
