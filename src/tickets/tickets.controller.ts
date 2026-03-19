import { Body, Controller, Get, Param, Post } from '@nestjs/common';
import { TicketsService } from './tickets.service';

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
    create(
        @Body('title') title: string,
        @Body('description') description?: string,
        @Body('customerEmail') customerEmail?: string,
    ) {
        return this.ticketService.create(
            title,
            description,
            customerEmail ?? 'test2@gmail.com',
        );
    }
}
