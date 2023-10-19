package com.example.springbootbsiccore.order;

import com.example.springbootbsiccore.member.Grade;
import com.example.springbootbsiccore.member.Member;
import com.example.springbootbsiccore.member.MemberService;
import com.example.springbootbsiccore.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceimpl();

    @Test
    void createOrder(){
        Long memeberId = 1L;
        Member member = new Member(memeberId, "memberA", Grade.VIP);
        memberService.joing(member);

        Order order = orderService.createOrder(memeberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);


    }
}
