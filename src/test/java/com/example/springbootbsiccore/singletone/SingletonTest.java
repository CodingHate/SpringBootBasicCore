package com.example.springbootbsiccore.singletone;

import com.example.springbootbsiccore.AppConfig;
import com.example.springbootbsiccore.member.MemberService;
import com.example.springbootbsiccore.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class SingletonTest {

    @Test
    @DisplayName("")
    public void pureContainer(){
        AppConfig appConfig = new AppConfig();

        // 1. 조회
        MemberService memberService01 = appConfig.memberService();

        // 2. 조회
        MemberService memberService02 = appConfig.memberService();

        //참조값이 다른 것을 확인
        System.out.println("memeberService 01 = " + memberService01);
        System.out.println("memeberService 02 = " + memberService02);

        Assertions.assertThat(memberService01).isNotSameAs(memberService02);
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    public void singletonServiceTest(){
        SingletonService singletonService01 = SingletonService.getInstance();
        SingletonService singletonService02 = SingletonService.getInstance();

        System.out.println("singletonService01 = " + singletonService01);
        System.out.println("singletonService02 = " + singletonService02);

        Assertions.assertThat(singletonService01).isSameAs(singletonService02);
    }
}
