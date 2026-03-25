package com.supporthub.api.tickets.controller;

import java.util.List;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.supporthub.api.tickets.dto.CreateTicketRequestDto;
import com.supporthub.api.tickets.dto.TicketResponse;
import com.supporthub.api.tickets.service.TicketsService;

@RestController
@RequestMapping("/tickets")
public class TicketsController {

    private final TicketsService ticketsService;

    public TicketsController(TicketsService ticketsService) {
        this.ticketsService = ticketsService;
    }

    @GetMapping
    public List<TicketResponse> findAll() {
        return ticketsService.findAll();
    }

    @GetMapping("/{id}")
    public TicketResponse findById(@PathVariable Long id) {
        return ticketsService.findById(id);
    }

    @PostMapping
    public TicketResponse create(@Valid @RequestBody CreateTicketRequestDto createTicketRequestDto) {
        return ticketsService.create(createTicketRequestDto);
    }
}
