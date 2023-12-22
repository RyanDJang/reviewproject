package com.plus.reviewproject.profile.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class NicknameResponseDto {
    private String username;
    private String nickname;
}
