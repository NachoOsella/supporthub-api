import { Injectable, NotFoundException } from '@nestjs/common';
import { Ticket } from './types/ticket.type';

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

    findAll(): Ticket[] {
        return this.tickets;
    }

    findById(id: number): Ticket {
        const ticket = this.tickets.find((item) => item.id === id);

        if (!ticket) {
            throw new NotFoundException('Ticket not finded');
        }

        return ticket;
    }

    create(
        title: string,
        description: string | undefined,
        customerEmail: string,
    ): Ticket {
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
}
