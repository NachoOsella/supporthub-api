import { ApiProperty } from '@nestjs/swagger';
import { IsEmail, IsString, MinLength } from 'class-validator';

export class CreateTicketDto {
    @ApiProperty()
    @IsString()
    @MinLength(5)
    title: string;

    @ApiProperty()
    @IsString()
    @MinLength(10)
    description: string;

    @ApiProperty()
    @IsEmail()
    customerEmail: string;
}
