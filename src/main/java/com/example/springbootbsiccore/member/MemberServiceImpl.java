package com.example.springbootbsiccore.member;

public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository; //= new MemoryMemberRepository();

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void joing(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
