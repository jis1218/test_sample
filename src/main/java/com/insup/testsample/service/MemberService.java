package com.insup.testsample.service;

import com.insup.testsample.domain.Member;
import com.insup.testsample.dto.MemberJoinRequest;
import com.insup.testsample.dto.MemberJoinResponse;
import com.insup.testsample.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper memberRepository;

    @Transactional
    public MemberJoinResponse join(MemberJoinRequest memberJoinRequest) {

        Member member = memberRepository.join(memberJoinRequest);

        return MemberJoinResponse.of(member);
    }
}
