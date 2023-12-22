package com.plus.reviewproject.profile.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AgeResponseDto {
    private String username;
    private int age;
}
