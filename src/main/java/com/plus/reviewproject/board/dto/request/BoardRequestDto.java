package com.plus.reviewproject.board.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardRequestDto {

    private String title;
    private String content;
    private String category;
    private String userId;
}
