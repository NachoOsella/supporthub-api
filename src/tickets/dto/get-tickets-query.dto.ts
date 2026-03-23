import { IsIn, IsOptional } from 'class-validator';
import type { TicketStatus } from '../types/ticket.type';
import { PaginationQueryDto } from 'src/common/dto/pagination-query.dto';

export class GetTicketsQueryDto extends PaginationQueryDto {
    @IsOptional()
    @IsIn(['open', 'in_progress', 'closed'])
    status?: TicketStatus;
}
