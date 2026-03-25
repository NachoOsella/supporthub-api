package com.supporthub.api.tickets.dto;

import com.supporthub.api.tickets.entity.TicketStatus;
import java.time.LocalDateTime;

public record TicketResponse(
        Long id,
        String title,
        String description,
        TicketStatus status,
        Long customerId,
        String customerEmail,
        LocalDateTime createdAt) {
}
