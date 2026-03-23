import { ApiProperty } from '@nestjs/swagger';
import { IsIn } from 'class-validator';

export class UpdateTicketStatusDto {
    @ApiProperty({ enum: ['open', 'in_progress', 'closed'] })
    @IsIn(['open', 'in_progress', 'closed'])
    status: 'open' | 'in_progress' | 'closed';
}
