import { IsIn } from 'class-validator';

export class UpdateTicketStatusDto {
    @IsIn(['open', 'in_progress', 'closed'])
    status: 'open' | 'in_progress' | 'closed';
}
