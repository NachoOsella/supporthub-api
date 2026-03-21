import {
    BadRequestException,
    Injectable,
    NotFoundException,
} from '@nestjs/common';
import { Ticket, TicketStatus } from './types/ticket.type';

@Injectable()
export class TicketsService {
    private readonly tickets: Ticket[] = [
        {
            id: 1,
            title: 'Issue with product',
            description: 'The product I received is defective.',
            status: 'open',
            customerEmail: 'test@gmail.com',
        },
    ];

    // Returns all tickets
    findAll(): Ticket[] {
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
    create(
        title: string,
        description: string | undefined,
        customerEmail: string,
    ): Ticket {
        if (!title || title.trim().length < 5) {
            throw new BadRequestException('Invalid title');
        }

        if (!customerEmail) {
            throw new BadRequestException('Customer email is required');
        }

        const newTicket: Ticket = {
            id: this.tickets.length + 1,
            title,
            description,
            customerEmail,
            status: 'open',
        };

        this.tickets.push(newTicket);
        return newTicket;
    }

    // Updates the status of the ticket
    updateStatus(id: number, newStatus: TicketStatus): Ticket {
        if (!newStatus) {
            throw new BadRequestException('newStatus is required');
        }

        if (!id) {
            throw new BadRequestException('The ticket Id is required');
        }

        this.validateStatus(newStatus);

        const ticket = this.findById(id);

        ticket.status = newStatus;

        return ticket;
    }

    private validateStatus(status: string): boolean {
        const validStatuses: TicketStatus[] = ['open', 'in_progress', 'closed'];

        if (!validStatuses.includes(status as TicketStatus)) {
            throw new BadRequestException('Invalid status value');
        }

        return true;
    }
}
