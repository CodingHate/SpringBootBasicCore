package com.example.springbootbsiccore;

import com.example.springbootbsiccore.discount.FixDiscountPolicy;
import com.example.springbootbsiccore.member.MemberService;
import com.example.springbootbsiccore.member.MemberServiceImpl;
import com.example.springbootbsiccore.member.MemoryMemberRepository;
import com.example.springbootbsiccore.order.OrderService;
import com.example.springbootbsiccore.order.OrderServiceimpl;

public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceimpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
