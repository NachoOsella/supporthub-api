package com.supporthub.api.tickets.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.supporthub.api.tickets.dto.CreateTicketRequestDto;
import com.supporthub.api.tickets.dto.TicketResponse;
import com.supporthub.api.tickets.entity.Ticket;

@Mapper(componentModel = "spring")
public interface TicketMapper {

    @Mapping(source = "tittle", target = "title")
    TicketResponse toResponse(Ticket ticket);

    @Mapping(source = "title", target = "tittle")
    Ticket toEntity(CreateTicketRequestDto dto);

    List<TicketResponse> toResponseList(List<Ticket> tickets);
}
