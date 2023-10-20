package com.example.springbootbsiccore;

import com.example.springbootbsiccore.member.Grade;
import com.example.springbootbsiccore.member.Member;
import com.example.springbootbsiccore.member.MemberService;
import com.example.springbootbsiccore.member.MemberServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootBsicCoreApplication {

    public static void main(String[] args)
    {
        AppConfig appConfig = new AppConfig();

        //MemberService memberService = new MemberServiceImpl();
        MemberService memberService = appConfig.memberService();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.joing(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName());
//        SpringApplication.run(SpringbootBsicCoreApplication.class, args);
    }

}
