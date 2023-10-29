package com.example.springbootbsiccore.order;

import com.example.springbootbsiccore.discount.DiscountPolicy;
import com.example.springbootbsiccore.discount.FixDiscountPolicy;
import com.example.springbootbsiccore.discount.RateDiscountPolicy;
import com.example.springbootbsiccore.member.Member;
import com.example.springbootbsiccore.member.MemberRepository;
import com.example.springbootbsiccore.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderServiceimpl implements OrderService {
    
    private MemberRepository memberRepository;
    private DiscountPolicy discountPolicy;

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
