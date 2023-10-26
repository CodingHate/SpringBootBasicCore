package com.example.springbootbsiccore.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository; //= new MemoryMemberRepository();

    @Autowired // 생성자; 자동으로 의존성을 주입 시켜준다. (@Component) // 마치 ac.getBean(MemberRepository.class) 와 동일 하다고 볼 수 있다.
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

    //테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
