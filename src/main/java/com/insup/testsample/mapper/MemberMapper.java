package com.insup.testsample.mapper;

import com.insup.testsample.domain.Member;
import com.insup.testsample.dto.MemberJoinRequest;
import com.insup.testsample.dto.MemberLoginRequest;
import com.insup.testsample.dto.MemberLoginResponse;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    void join(MemberJoinRequest memberJoinRequest);

    int login(MemberLoginRequest memberLoginRequest);
}
