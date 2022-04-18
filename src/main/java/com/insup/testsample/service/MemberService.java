package com.insup.testsample.service;

import com.insup.testsample.dto.MemberJoinRequest;
import com.insup.testsample.dto.MemberLoginRequest;
import com.insup.testsample.dto.MemberLoginResponse;
import com.insup.testsample.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper memberRepository;

    @Transactional
    public void join(MemberJoinRequest memberJoinRequest) {
        memberRepository.join(memberJoinRequest);
    }

    @Transactional
    public MemberLoginResponse login(MemberLoginRequest memberLoginRequest) {
        int count = memberRepository.login(memberLoginRequest);

        return new MemberLoginResponse(count);
    }
}
