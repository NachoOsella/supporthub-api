import { IsIn, IsOptional } from 'class-validator';
import type { TicketStatus } from '../types/ticket.type';

export class GetTicketsQueryDto {
    @IsOptional()
    @IsIn(['open', 'in_progress', 'closed'])
    status?: TicketStatus;
}
