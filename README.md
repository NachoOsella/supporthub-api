# supporthub-api (Spring Boot scaffold)

Proyecto base en Spring Boot para implementar desde cero.

## Estructura

Cada modulo mantiene estructura de scaffolding:

- `controller`
- `service`
- `repository`
- `dto`
- `entity`

Modulos incluidos:

- `users`
- `tickets`
- `comments`
- `attachments`
- `notifications`
- `audit-log`

## Modelo De Entidades Recomendado

La idea del proyecto es que el dominio quede asi:

```text
User 1 --- * Ticket        (customer)
User 1 --- * Ticket        (assignedAgent, opcional)
Ticket 1 --- * Comment
User 1 --- * Comment       (author)
Ticket 1 --- * Attachment
User 1 --- * Attachment    (uploadedBy)
User 1 --- * Notification
Ticket 1 --- * AuditLog    (opcional)
User 1 --- * AuditLog      (actor, opcional)
```

### `User`

Campos recomendados:

- `id: Long`
- `email: String` (`nullable = false`, `unique = true`)
- `name: String` (`nullable = false`)
- `passwordHash: String` (`nullable = false`)
- `role: UserRole` (`ADMIN`, `AGENT`, `CUSTOMER`)
- `createdAt: LocalDateTime`

Relaciones recomendadas:

- `customerTickets` -> `@OneToMany(mappedBy = "customer")`
- `assignedTickets` -> `@OneToMany(mappedBy = "assignedAgent")`
- `authoredComments` -> `@OneToMany(mappedBy = "author")`
- `uploadedAttachments` -> `@OneToMany(mappedBy = "uploadedBy")`
- `notifications` -> `@OneToMany(mappedBy = "user")`

### `Ticket`

Campos recomendados:

- `id: Long`
- `title: String` (`nullable = false`, `length = 200`)
- `description: String` (`length = 1000`)
- `status: TicketStatus` con `@Enumerated(EnumType.STRING)`
- `createdAt: LocalDateTime`

Modelo objetivo:

- `customer` -> `@ManyToOne(fetch = FetchType.LAZY, optional = false)`
- `assignedAgent` -> `@ManyToOne(fetch = FetchType.LAZY, optional = true)`
- `comments` -> `@OneToMany(mappedBy = "ticket")`
- `attachments` -> `@OneToMany(mappedBy = "ticket")`

### `Comment`

Campos recomendados:

- `id: Long`
- `body: String` (`nullable = false`, `length = 2000`)
- `createdAt: LocalDateTime`

Relaciones recomendadas:

- `ticket` -> `@ManyToOne(fetch = FetchType.LAZY)`
- `author` -> `@ManyToOne(fetch = FetchType.LAZY)`

### `Attachment`

Campos recomendados:

- `id: Long`
- `fileName: String`
- `storageKey: String`
- `contentType: String`
- `sizeBytes: Long`
- `createdAt: LocalDateTime`

Relaciones recomendadas:

- `ticket` -> `@ManyToOne(fetch = FetchType.LAZY)`
- `uploadedBy` -> `@ManyToOne(fetch = FetchType.LAZY)`

### `Notification`

Campos recomendados:

- `id: Long`
- `type: String` o `NotificationType`
- `message: String`
- `read: boolean`
- `createdAt: LocalDateTime`

Relaciones recomendadas:

- `user` -> `@ManyToOne(fetch = FetchType.LAZY)`
- `ticket` -> `@ManyToOne(fetch = FetchType.LAZY, optional = true)`

### `AuditLog`

Campos recomendados:

- `id: Long`
- `action: String` o `AuditAction`
- `entityType: String`
- `entityId: Long`
- `details: String`
- `createdAt: LocalDateTime`

Relaciones recomendadas:

- `actor` -> `@ManyToOne(fetch = FetchType.LAZY, optional = true)`
- `ticket` -> `@ManyToOne(fetch = FetchType.LAZY, optional = true)` si queres navegar facil desde ticket

## Orden Recomendado De Implementacion

1. `Ticket` bien cerrado como entidad base
2. `User` + `UserRole`
3. relacion `Ticket -> User`
4. `Comment` con `ticket` y `author`
5. `Attachment`
6. `Notification`
7. `AuditLog`

## Ejecutar

```bash
mvn spring-boot:run
```

## Test

```bash
mvn test
```
