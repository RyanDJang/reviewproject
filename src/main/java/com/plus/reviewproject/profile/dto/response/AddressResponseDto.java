package com.plus.reviewproject.profile.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AddressResponseDto {
    private String username;
    private String address;
}
