package com.insup.testsample.mapper;

import com.insup.testsample.domain.Member;
import com.insup.testsample.dto.MemberJoinRequest;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    Member join(MemberJoinRequest memberJoinRequest);
}
