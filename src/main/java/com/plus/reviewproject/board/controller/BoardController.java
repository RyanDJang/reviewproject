package com.plus.reviewproject.board.controller;

import com.plus.reviewproject.CommonResponseDto;
import com.plus.reviewproject.board.dto.request.BoardRequestDto;
import com.plus.reviewproject.board.dto.response.BoardListResponseDto;
import com.plus.reviewproject.board.dto.response.BoardResponseDto;
import com.plus.reviewproject.board.service.BoardService;
import com.plus.reviewproject.user.dto.UserInfoDto;
import com.plus.reviewproject.user.userDetails.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/v1/boards")
@RestController
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @PostMapping
    public ResponseEntity<BoardResponseDto> boardId(@RequestBody BoardRequestDto boardRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails){
        BoardResponseDto responseDto = boardService.createBoard(boardRequestDto, userDetails.getUser());

        return ResponseEntity.status(201).body(responseDto);
    }

    @GetMapping("/{boardId}")
    public ResponseEntity<CommonResponseDto> getBoard(@PathVariable Long boardId) {
        try {
            BoardResponseDto boardResponseDto = boardService.getBoard(boardId);
            return ResponseEntity.ok().body(boardResponseDto);
        } catch (IllegalArgumentException e) {
            CommonResponseDto commonResponseDto = new CommonResponseDto(e.getMessage(), HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.badRequest().body(commonResponseDto);
        }
    }

    @GetMapping
    public ResponseEntity<List<BoardListResponseDto>> getBoardList(){
        List<BoardListResponseDto> response = new ArrayList<>();

        Map<UserInfoDto, List<BoardResponseDto>> responseDtoMap = boardService.getUserBoardMap();

        responseDtoMap.forEach((key, value) -> response.add(new BoardListResponseDto(key, value)));

        return ResponseEntity.ok().body(response);
    }

    @PatchMapping("/{boardId}")
    public ResponseEntity<CommonResponseDto> patchBoard(@PathVariable Long boardId, @RequestBody BoardRequestDto boardRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) { //로그인
        try {
            BoardResponseDto boardResponseDto = boardService.updateBoard(boardId, boardRequestDto, userDetails.getUser());
            return ResponseEntity.ok().body(boardResponseDto);
        } catch (IllegalArgumentException e) {
            CommonResponseDto commonResponseDto = new CommonResponseDto(e.getMessage(), HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.badRequest().body(commonResponseDto);
        }
    }

    @DeleteMapping("/{boardId}")
    public ResponseEntity<CommonResponseDto> deleteBoard(@PathVariable Long boardId, @AuthenticationPrincipal UserDetailsImpl userDetails) { //로그인
        try {
            boardService.deleteBoard(boardId, userDetails.getUser());
            return ResponseEntity.ok().body(new CommonResponseDto("게시글 삭제가 완료되었습니다.", HttpStatus.OK.value()));
        } catch (IllegalArgumentException e) {
            CommonResponseDto commonResponseDto = new CommonResponseDto(e.getMessage(), HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.badRequest().body(commonResponseDto);
        }
    }

}