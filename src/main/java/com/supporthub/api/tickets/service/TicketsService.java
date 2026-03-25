package com.supporthub.api.tickets.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.supporthub.api.tickets.dto.CreateTicketRequestDto;
import com.supporthub.api.tickets.dto.TicketResponse;
import com.supporthub.api.tickets.entity.Ticket;
import com.supporthub.api.tickets.mapper.TicketMapper;
import com.supporthub.api.tickets.repository.TicketRepository;

@Service
public class TicketsService {
    private final TicketRepository ticketRepository;
    private final TicketMapper ticketMapper;

    public TicketsService(TicketRepository ticketRepository, TicketMapper ticketMapper) {
        this.ticketRepository = ticketRepository;
        this.ticketMapper = ticketMapper;
    }

    public List<TicketResponse> findAll() {
        List<Ticket> tickets = ticketRepository.findAll();
        return ticketMapper.toResponseList(tickets);
    }

    public TicketResponse findById(Long id) {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ticket not found"));
        return ticketMapper.toResponse(ticket);
    }

    public TicketResponse create(CreateTicketRequestDto createDto) {
        Ticket ticket = ticketMapper.toEntity(createDto);

        Ticket saved = ticketRepository.save(ticket);

        return ticketMapper.toResponse(saved);
    }
}
