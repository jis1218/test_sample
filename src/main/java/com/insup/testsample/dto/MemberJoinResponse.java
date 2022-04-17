package com.insup.testsample.dto;

import com.insup.testsample.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberJoinResponse {
    private long id;
    private String email;

    public static MemberJoinResponse of(Member member) {
        return new MemberJoinResponse(
                member.getId(),
                member.getEmail()
        );
    }
}
