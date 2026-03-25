package com.supporthub.api.tickets.entity;


import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tickets")
@Data
@NoArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 200)
    private String tittle;

    @Size(max = 1000)
    private String description;

    @NotNull
    private TicketStatus status;

    @NotNull
    @Email
    private String customerEmail;

    @NotNull
    private LocalDateTime createdAt;

    @PrePersist
    void prePersist() {
        if (status == null) {
            status = TicketStatus.OPEN;
        }
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
    }
}
