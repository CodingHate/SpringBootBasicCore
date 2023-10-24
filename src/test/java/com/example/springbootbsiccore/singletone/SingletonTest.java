package com.example.springbootbsiccore.singletone;

import com.example.springbootbsiccore.AppConfig;
import com.example.springbootbsiccore.member.MemberService;
import com.example.springbootbsiccore.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SingletonTest {

    @Test
    @DisplayName("스프리이 없는 순수한 DI 컨테이너")
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

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    public void springContainer(){
        //        AppConfig appConfig = new AppConfig();
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        // 1. 조회
        MemberService memberService01 = ac.getBean("memberService", MemberService.class);
        MemberService memberService02 = ac.getBean("memberService", MemberService.class);

        //참조값이 다른 것을 확인
        System.out.println("memeberService01 = " + memberService01);
        System.out.println("memeberService02 = " + memberService02);

        Assertions.assertThat(memberService01).isSameAs(memberService02);
    }
}
