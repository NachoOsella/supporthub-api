package com.supporthub.api.comments.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.supporthub.api.comments.dto.CommentResponse;
import com.supporthub.api.comments.dto.CreateCommentDto;
import com.supporthub.api.comments.entity.Comment;

@Component
public class CommentMapper {

    public CommentResponse toResponse(Comment comment) {
        return new CommentResponse(comment.getId(), comment.getBody(), comment.getTicket().getId(),
                comment.getCreatedAt());
    }

    public Comment toEntity(CreateCommentDto dto) {
        Comment comment = new Comment();
        comment.setBody(dto.body());
        return comment;
    }

    public List<CommentResponse> toResponseList(List<Comment> comments) {
        return comments.stream().map(this::toResponse).toList();
    }
}
