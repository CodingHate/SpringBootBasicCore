package com.example.springbootbsiccore;

import com.example.springbootbsiccore.discount.DiscountPolicy;
import com.example.springbootbsiccore.discount.RateDiscountPolicy;
import com.example.springbootbsiccore.member.MemberRepository;
import com.example.springbootbsiccore.member.MemberService;
import com.example.springbootbsiccore.member.MemberServiceImpl;
import com.example.springbootbsiccore.member.MemoryMemberRepository;
import com.example.springbootbsiccore.order.OrderService;
import com.example.springbootbsiccore.order.OrderServiceimpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService(){
        return new OrderServiceimpl(memberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy(){
        //        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
