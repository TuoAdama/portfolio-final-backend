package com.portfolio.adama.requests;

public record CommentRequest(
        String email,
        String subject,
        String body
) {
}
