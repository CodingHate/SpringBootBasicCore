package com.example.springbootbsiccore;

import com.example.springbootbsiccore.member.Grade;
import com.example.springbootbsiccore.member.Member;
import com.example.springbootbsiccore.member.MemberService;
import com.example.springbootbsiccore.member.MemberServiceImpl;
import com.example.springbootbsiccore.order.Order;
import com.example.springbootbsiccore.order.OrderService;
import com.example.springbootbsiccore.order.OrderServiceimpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args){
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade .VIP);
        memberService.joing(member);

        Order order = orderService.createOrder(memberId, "itemA", 20000);

        System.out.println("order = " + order.toString());
    }
}
