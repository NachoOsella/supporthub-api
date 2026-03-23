import {
    BadRequestException,
    Injectable,
    NotFoundException,
} from '@nestjs/common';
import { Ticket, TicketStatus } from './types/ticket.type';
import { CreateTicketDto } from './dto/create-ticket.dto';
import { UpdateTicketStatusDto } from './dto/update-ticket-status.dto';

@Injectable()
export class TicketsService {
    private tickets: Ticket[] = [];

    // Returns all tickets, optionally filtered by status
    findAll(status?: TicketStatus): Ticket[] {
        if (status) {
            return this.tickets.filter((ticket) => ticket.status === status);
        }
        return this.tickets;
    }

    // Returns a ticket by its ID
    findById(id: number): Ticket {
        const ticket = this.tickets.find((item) => item.id === id);

        if (!ticket) {
            throw new NotFoundException('Ticket not found');
        }

        return ticket;
    }

    // Creates a new ticket and adds it to the list
    create(dto: CreateTicketDto): Ticket {
        const newTicket: Ticket = {
            id: this.tickets.length + 1,
            title: dto.title,
            description: dto.description,
            customerEmail: dto.customerEmail,
            status: 'open',
        };

        this.tickets.push(newTicket);
        return newTicket;
    }

    // Updates the status of the ticket
    updateStatus(id: number, updateStatusDto: UpdateTicketStatusDto): Ticket {
        if (!id) {
            throw new BadRequestException('The ticket Id is required');
        }

        const ticket = this.findById(id);

        ticket.status = updateStatusDto.status;

        return ticket;
    }
}
