package com.supporthub.api.comments.repository;

import com.supporthub.api.comments.entity.Comment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByTicket_Id(Long ticketId);
}
