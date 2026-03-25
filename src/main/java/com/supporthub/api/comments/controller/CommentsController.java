package com.supporthub.api.comments.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.supporthub.api.comments.dto.CommentResponse;
import com.supporthub.api.comments.dto.CreateCommentDto;
import com.supporthub.api.comments.service.CommentsService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tickets/{ticketId}/comments")
public class CommentsController {

    private final CommentsService commentsService;

    public CommentsController(CommentsService commentsService) {
        this.commentsService = commentsService;
    }

    @GetMapping
    public List<CommentResponse> findByTicketId(@PathVariable Long ticketId) {
        return commentsService.findByTicketId(ticketId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CommentResponse create(@PathVariable Long ticketId, @Valid @RequestBody CreateCommentDto requestDto) {
        return commentsService.create(requestDto);
    }
}
