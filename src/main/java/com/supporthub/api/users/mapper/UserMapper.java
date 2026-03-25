package com.supporthub.api.users.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.supporthub.api.users.dto.CreateUserRequestDto;
import com.supporthub.api.users.dto.UserResponse;
import com.supporthub.api.users.entity.User;

@Component
public class UserMapper {

    public UserResponse toResponse(User user) {
        return new UserResponse(user.getId(), user.getEmail(), user.getName(), user.getRole(), user.getCreatedAt());
    }

    public User toEntity(CreateUserRequestDto dto) {
        User user = new User();
        user.setEmail(dto.email());
        user.setName(dto.name());
        return user;
    }

    public List<UserResponse> toResponseList(List<User> users) {
        return users.stream().map(this::toResponse).toList();
    }
}
