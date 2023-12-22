package com.plus.reviewproject.comment.entity;

import com.plus.reviewproject.Timestamped;
import com.plus.reviewproject.board.entity.Board;
import com.plus.reviewproject.comment.dto.CommentRequestDto;
import com.plus.reviewproject.comment.dto.CommentResponseDto;
import com.plus.reviewproject.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Table
@Entity
@NoArgsConstructor
public class Comment extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String content;

    // post, user 관계설정하기
    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "postId")
    private Long postId;

    public Comment(Board board, CommentRequestDto commentRequestDto, User user) {
        this.content = commentRequestDto.getContent();
        // post 정보 저장하기
        this.board = board;
        // user 정보 저장하기
        this.user = user;
        this.postId = board.getId();
    }


    public CommentResponseDto update(CommentRequestDto commentRequestDto) {
        this.content = commentRequestDto.getContent();
        return new CommentResponseDto(this);
    }
}