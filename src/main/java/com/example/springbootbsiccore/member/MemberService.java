package com.example.springbootbsiccore.member;

public interface MemberService {
    void joing(Member member);
    Member findMember(Long memberId);
}
