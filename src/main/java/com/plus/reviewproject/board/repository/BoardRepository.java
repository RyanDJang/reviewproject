package com.plus.reviewproject.board.repository;

import com.plus.reviewproject.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}

