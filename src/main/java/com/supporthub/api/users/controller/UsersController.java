package com.supporthub.api.users.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.supporthub.api.users.dto.CreateUserRequestDto;
import com.supporthub.api.users.dto.UserResponse;
import com.supporthub.api.users.repository.UserRepository;
import com.supporthub.api.users.service.UsersService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UsersController {

    private final UserRepository userRepository;
    private final UsersService usersService;

    public UsersController(UserRepository userRepository, UsersService usersService) {
        this.userRepository = userRepository;
        this.usersService = usersService;
    }

    @GetMapping
    public List<UserResponse> findAll() {
        return usersService.findAll();
    }

    @GetMapping("{/id}")
    public UserResponse findById(@PathVariable Long id) {
        return usersService.findById(id);
    }

    @PostMapping
    public UserResponse create(@Valid @RequestBody CreateUserRequestDto requestDto) {
        return usersService.create(requestDto);
    }
}
