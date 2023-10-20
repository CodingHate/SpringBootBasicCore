package com.example.springbootbsiccore;

import com.example.springbootbsiccore.discount.DiscountPolicy;
import com.example.springbootbsiccore.discount.FixDiscountPolicy;
import com.example.springbootbsiccore.discount.RateDiscountPolicy;
import com.example.springbootbsiccore.member.MemberRepository;
import com.example.springbootbsiccore.member.MemberService;
import com.example.springbootbsiccore.member.MemberServiceImpl;
import com.example.springbootbsiccore.member.MemoryMemberRepository;
import com.example.springbootbsiccore.order.OrderService;
import com.example.springbootbsiccore.order.OrderServiceimpl;

public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }


    public OrderService orderService(){
        return new OrderServiceimpl(memberRepository(), discountPolicy());
    }

    private DiscountPolicy discountPolicy(){
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
