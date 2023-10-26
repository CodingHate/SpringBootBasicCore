package com.example.springbootbsiccore.order;

import com.example.springbootbsiccore.discount.DiscountPolicy;
import com.example.springbootbsiccore.discount.FixDiscountPolicy;
import com.example.springbootbsiccore.discount.RateDiscountPolicy;
import com.example.springbootbsiccore.member.Member;
import com.example.springbootbsiccore.member.MemberRepository;
import com.example.springbootbsiccore.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceimpl implements OrderService {
    
    // private final MemberRepository memberRepository = new MemoryMemberRepository();
    // private final DiscountPolicy discountPolicy = new FindDiscountPolicy();
    // private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    private MemberRepository memberRepository;
    private DiscountPolicy discountPolicy;


    @Autowired
    public OrderServiceimpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member memeber = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(memeber, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // 테스트 용도

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
