import { Module } from '@nestjs/common';
import { AppController } from './app.controller';
import { AppService } from './app.service';
import { AuthModule } from './auth/auth.module';
import { UsersModule } from './users/users.module';
import { AttachmentsModule } from './attachments/attachments.module';
import { CommentsModule } from './comments/comments.module';
import { TicketsModule } from './tickets/tickets.module';
import { AuditLogModule } from './audit-log/audit-log.module';
import { NotificationsModule } from './notifications/notifications.module';
import { PrismaModule } from './prisma/prisma.module';
import { CommonModule } from './common/common.module';

@Module({
    imports: [
        AuthModule,
        UsersModule,
        TicketsModule,
        CommentsModule,
        AttachmentsModule,
        AuditLogModule,
        NotificationsModule,
        PrismaModule,
        CommonModule,
    ],
    controllers: [AppController],
    providers: [AppService],
})
export class AppModule {}
