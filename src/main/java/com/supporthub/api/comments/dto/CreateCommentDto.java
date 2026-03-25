package com.supporthub.api.comments.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreateCommentDto(
        @NotBlank @Size(max = 2000) String body,
        @NotNull Long ticketId) {
}
