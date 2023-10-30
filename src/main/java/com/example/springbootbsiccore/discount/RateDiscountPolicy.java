package com.example.springbootbsiccore.discount;

import com.example.springbootbsiccore.annotation.MainDiscountPolicy;
import com.example.springbootbsiccore.member.Grade;
import com.example.springbootbsiccore.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if(member.getGread() == Grade.VIP){
            return price * discountPercent / 100;
        }
        else{
            return 0;
        }
    }
}
