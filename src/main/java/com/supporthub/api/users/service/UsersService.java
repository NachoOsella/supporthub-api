package com.supporthub.api.users.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.supporthub.api.users.dto.CreateUserRequestDto;
import com.supporthub.api.users.dto.UserResponse;
import com.supporthub.api.users.entity.User;
import com.supporthub.api.users.mapper.UserMapper;
import com.supporthub.api.users.repository.UserRepository;

@Service
public class UsersService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UsersService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<UserResponse> findAll() {
        List<User> users = userRepository.findAll();
        return userMapper.toResponseList(users);
    }

    public UserResponse findById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        return userMapper.toResponse(user);
    }

    public UserResponse create(CreateUserRequestDto request) {
        if (userRepository.existsByEmail(request.email())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already in use");
        }

        User user = userMapper.toEntity(request);
        user.setPasswordHash("placeholder");

        User savedUser = userRepository.save(user);
        return userMapper.toResponse(savedUser);
    }
}
