package com.supporthub.api.tickets.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.supporthub.api.tickets.dto.CreateTicketRequestDto;
import com.supporthub.api.tickets.dto.TicketResponse;
import com.supporthub.api.tickets.entity.Ticket;

@Component
public class TicketMapper {

    public TicketResponse toResponse(Ticket ticket) {
        return new TicketResponse(
                ticket.getId(),
                ticket.getTitle(),
                ticket.getDescription(),
                ticket.getStatus(),
                ticket.getCustomer().getId(),
                ticket.getCustomer().getEmail(),
                ticket.getCreatedAt());
    }

    public Ticket toEntity(CreateTicketRequestDto dto) {
        Ticket ticket = new Ticket();
        ticket.setTitle(dto.title());
        ticket.setDescription(dto.description());
        return ticket;
    }

    public List<TicketResponse> toResponseList(List<Ticket> tickets) {
        return tickets.stream()
                .map(this::toResponse)
                .toList();
    }
}
