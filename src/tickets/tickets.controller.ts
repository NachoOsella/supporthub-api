import { Body, Controller, Get, Param, Patch, Post } from '@nestjs/common';
import { ApiTags } from '@nestjs/swagger';
import { TicketsService } from './tickets.service';
import { CreateTicketDto } from './dto/create-ticket.dto';
import { UpdateTicketStatusDto } from './dto/update-ticket-status.dto';

@ApiTags('tickets')
@Controller('tickets')
export class TicketsController {
    constructor(private readonly ticketService: TicketsService) {}

    @Get()
    findAll() {
        return this.ticketService.findAll();
    }

    @Get(':id')
    findById(@Param('id') id: string) {
        return this.ticketService.findById(Number(id));
    }

    @Post()
    create(@Body() dto: CreateTicketDto) {
        return this.ticketService.create(dto);
    }

    @Patch(':id/status')
    updateStatus(
        @Param('id') id: string,
        @Body() statusDto: UpdateTicketStatusDto,
    ) {
        return this.ticketService.updateStatus(Number(id), statusDto);
    }
}
