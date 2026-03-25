package com.supporthub.api.comments.dto;

import java.time.LocalDateTime;

public record CommentResponse(
        Long id,
        String body,
        Long ticketId,
        LocalDateTime createdAt) {
}
