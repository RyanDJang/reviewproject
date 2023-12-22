package com.plus.reviewproject.profile.controller;

import com.plus.reviewproject.profile.dto.request.AddressRequestDto;
import com.plus.reviewproject.profile.dto.request.AgeRequestDto;
import com.plus.reviewproject.profile.dto.request.NicknameRequestDto;
import com.plus.reviewproject.profile.dto.request.PhoneNumberRequestDto;
import com.plus.reviewproject.profile.dto.response.AddressResponseDto;
import com.plus.reviewproject.profile.dto.response.AgeResponseDto;
import com.plus.reviewproject.profile.dto.response.NicknameResponseDto;
import com.plus.reviewproject.profile.dto.response.PhoneNumberResponseDto;
import com.plus.reviewproject.profile.entity.Profile;
import com.plus.reviewproject.user.service.UserService;
import com.plus.reviewproject.user.userDetails.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/profile")
public class ProfileController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<Profile> myProfile(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        log.info("getgetgeetgetgetgegt");
        Profile profile1 = userService.getUserData(userDetails.getUser());
        return ResponseEntity.ok(profile1);
    }

    @PostMapping("/nickname")
    public ResponseEntity<NicknameResponseDto> updateNickname(@RequestBody NicknameRequestDto nicknameRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) throws ChangeSetPersister.NotFoundException {
        NicknameResponseDto responseDto = userService.updateNickname(userDetails.getUser(), nicknameRequestDto);
        return ResponseEntity.ok(responseDto);
    }

    @PostMapping("/address")
    public ResponseEntity<AddressResponseDto> updateAddress(@RequestBody AddressRequestDto addressRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) throws ChangeSetPersister.NotFoundException {
        AddressResponseDto responseDto = userService.updateAddress(userDetails.getUser(), addressRequestDto);
        return ResponseEntity.ok(responseDto);
    }

    @PostMapping("/age")
    public ResponseEntity<AgeResponseDto> updateAge(@RequestBody AgeRequestDto ageRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) throws ChangeSetPersister.NotFoundException {
        AgeResponseDto responseDto = userService.updateAge(userDetails.getUser(), ageRequestDto);
        return ResponseEntity.ok(responseDto);
    }

    @PostMapping("/phonenumber")
    public ResponseEntity<PhoneNumberResponseDto> updatePhonenumber(@RequestBody PhoneNumberRequestDto phoneNumberRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) throws ChangeSetPersister.NotFoundException {
        PhoneNumberResponseDto responseDto = userService.updatePhoneNumber(userDetails.getUser(), phoneNumberRequestDto);
        return ResponseEntity.ok(responseDto);
    }
}
