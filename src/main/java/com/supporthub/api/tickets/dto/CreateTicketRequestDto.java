package com.supporthub.api.tickets.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateTicketRequestDto(@NotBlank @Size(max = 200) String title, @Size(max = 1000) String description,
        @NotBlank @Email String customerEmail) {
}
