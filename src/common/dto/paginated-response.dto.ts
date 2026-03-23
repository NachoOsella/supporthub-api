import { ApiProperty } from '@nestjs/swagger';

class PaginationMeta {
    @ApiProperty()
    total: number;

    @ApiProperty()
    page: number;

    @ApiProperty()
    limit: number;

    @ApiProperty()
    totalPages: number;
}

export class PaginatedResponseDto<T> {
    data: T[];

    @ApiProperty()
    meta: PaginationMeta;

    constructor(data: T[], total: number, page: number, limit: number) {
        this.data = data;
        this.meta = {
            total,
            page,
            limit,
            totalPages: Math.ceil(total / limit),
        };
    }
}
