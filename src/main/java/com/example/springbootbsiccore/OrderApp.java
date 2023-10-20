package com.example.springbootbsiccore;

import com.example.springbootbsiccore.member.Grade;
import com.example.springbootbsiccore.member.Member;
import com.example.springbootbsiccore.member.MemberService;
import com.example.springbootbsiccore.member.MemberServiceImpl;
import com.example.springbootbsiccore.order.Order;
import com.example.springbootbsiccore.order.OrderService;
import com.example.springbootbsiccore.order.OrderServiceimpl;

public class OrderApp {

    public static void main(String[] args){
        AppConfig appConfig = new AppConfig();
        //MemberService memberService = new MemberServiceImpl(null);
        //OrderService orderService = new OrderServiceimpl(null, null);

        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade .VIP);
        memberService.joing(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order.toString());
    }
}
