package com.supporthub.api.users.dto;

import com.supporthub.api.users.entity.UserRole;
import java.time.LocalDateTime;

public record UserResponse(
        Long id,
        String email,
        String name,
        UserRole role,
        LocalDateTime createdAt) {
}
