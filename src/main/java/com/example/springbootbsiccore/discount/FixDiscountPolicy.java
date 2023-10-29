package com.example.springbootbsiccore.discount;

import com.example.springbootbsiccore.member.Grade;
import com.example.springbootbsiccore.member.Member;
import org.springframework.stereotype.Component;

@Component
public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmound = 1000; // 1000원

    @Override
    public int discount(Member member, int price) {
        if(member.getGread() == Grade.VIP){
            return discountFixAmound;
        }
        else{
            return 0;
        }
    }
}
