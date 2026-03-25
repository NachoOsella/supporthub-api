package com.supporthub.api.tickets.dto;

import java.time.LocalDateTime;

public record TicketResponse(String id, String title, String description, String customerEmail,
        LocalDateTime createdAt) {
}
