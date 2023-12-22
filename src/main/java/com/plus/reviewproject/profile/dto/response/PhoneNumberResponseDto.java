package com.plus.reviewproject.profile.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PhoneNumberResponseDto {
    private String username;
    private String phonenumber;
}
