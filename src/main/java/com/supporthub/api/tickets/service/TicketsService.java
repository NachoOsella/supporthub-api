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
import com.supporthub.api.users.entity.User;
import com.supporthub.api.users.repository.UserRepository;

@Service
public class TicketsService {
    private final TicketRepository ticketRepository;
    private final TicketMapper ticketMapper;
    private final UserRepository userRepository;

    public TicketsService(TicketRepository ticketRepository, TicketMapper ticketMapper, UserRepository userRepository) {
        this.ticketRepository = ticketRepository;
        this.ticketMapper = ticketMapper;
        this.userRepository = userRepository;
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
        User customer = userRepository.findById(createDto.customerId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found"));
        ticket.setCustomer(customer);

        Ticket saved = ticketRepository.save(ticket);

        return ticketMapper.toResponse(saved);
    }
}
