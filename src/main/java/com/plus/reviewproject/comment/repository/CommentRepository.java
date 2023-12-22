package com.plus.reviewproject.comment.repository;

import com.plus.reviewproject.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllBypostId(Long postId);
}
