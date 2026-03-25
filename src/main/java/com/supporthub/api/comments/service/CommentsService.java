package com.supporthub.api.comments.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.supporthub.api.comments.dto.CommentResponse;
import com.supporthub.api.comments.dto.CreateCommentDto;
import com.supporthub.api.comments.entity.Comment;
import com.supporthub.api.comments.mapper.CommentMapper;
import com.supporthub.api.comments.repository.CommentRepository;

@Service
public class CommentsService {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;

    public CommentsService(CommentMapper commentMapper, CommentRepository commentRepository) {
        this.commentMapper = commentMapper;
        this.commentRepository = commentRepository;
    }

    public List<CommentResponse> findAll() {
        List<Comment> comments = commentRepository.findAll();
        return commentMapper.toResponseList(comments);
    }

    public CommentResponse findById(Long id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Comment not find"));

        return commentMapper.toResponse(comment);
    }

    public List<CommentResponse> findByTicketId(Long ticketId) {
        List<Comment> comments = commentRepository.findByTicket_Id(ticketId);

        return commentMapper.toResponseList(comments);
    }

    public CommentResponse create(CreateCommentDto request) {
        Comment comment = commentMapper.toEntity(request);
        Comment saved = commentRepository.save(comment);
        return commentMapper.toResponse(saved);
    }
}
