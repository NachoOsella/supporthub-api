import {
    BadRequestException,
    Injectable,
    NotFoundException,
} from '@nestjs/common';
import { TicketStatus } from './types/ticket.type';
import { CreateTicketDto } from './dto/create-ticket.dto';
import { UpdateTicketStatusDto } from './dto/update-ticket-status.dto';
import { PrismaService } from 'src/prisma/prisma.service';

@Injectable()
export class TicketsService {
    constructor(private readonly prisma: PrismaService) {}

    // Returns all tickets, optionally filtered by status
    findAll(status?: TicketStatus) {
        return this.prisma.ticket.findMany({
            where: status ? { status } : {},
            include: { customer: true },
            take: 20,
        });
    }

    // Returns a ticket by its ID
    async findById(id: number) {
        const ticket = await this.prisma.ticket.findUnique({
            where: { id },
            include: { customer: true },
        });

        if (!ticket) {
            throw new NotFoundException(`Ticket with ID ${id} not found`);
        }

        return ticket;
    }

    // Creates a new ticket and adds it to the list
    async create(dto: CreateTicketDto) {
        const newTicket = this.prisma.ticket.create({
            data: {
                title: dto.title,
                description: dto.description,
                status: 'open',
                customer: {
                    connectOrCreate: {
                        where: { email: dto.customerEmail },
                        create: { email: dto.customerEmail },
                    },
                },
            },
            include: { customer: true },
        });

        return newTicket;
    }

    // Updates the status of the ticket
    async updateStatus(id: number, updateStatusDto: UpdateTicketStatusDto) {
        if (!id) {
            throw new BadRequestException('The ticket Id is required');
        }

        await this.findById(id);

        return this.prisma.ticket.update({
            where: { id },
            data: { status: updateStatusDto.status },
            include: { customer: true },
        });
    }
}
