package com.insup.testsample.controller;

import com.insup.testsample.dto.MemberJoinRequest;
import com.insup.testsample.dto.MemberLoginRequest;
import com.insup.testsample.dto.MemberLoginResponse;
import com.insup.testsample.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/member")
@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/join")
    public ResponseEntity join(@RequestBody MemberJoinRequest memberJoinRequest) {
        memberService.join(memberJoinRequest);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody MemberLoginRequest memberLoginRequest) {
        MemberLoginResponse memberLoginResponse = memberService.login(memberLoginRequest);
        return ResponseEntity.ok(memberLoginResponse);
    }
}
