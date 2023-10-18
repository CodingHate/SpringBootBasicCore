package com.example.springbootbsiccore.member;

public interface MemberRepository {
    void save(Member member);
    Member findById(Long memberId);
}
