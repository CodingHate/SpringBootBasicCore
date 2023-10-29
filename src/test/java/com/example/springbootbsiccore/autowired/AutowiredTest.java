package com.example.springbootbsiccore.autowired;

import com.example.springbootbsiccore.member.Member;
import jakarta.annotation.Nullable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Optional;

public class AutowiredTest {
    @Test
    public void AutowiredOption(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }
    static class TestBean{

        @Autowired(required = false)
        public void setNoBean1(Member noBean1){
            System.out.println("TestBean.setNoBean1 = " +noBean1);
        }

        @Autowired
        public void setNoBean2(@Nullable Member noBean2){
            System.out.println("TestBean.setNoBean2 = " +noBean2);
        }

        @Autowired
        public void setNoBean3(Optional<Member> noBean3)
        {
            System.out.println("TestBean.setNoBean3 = " +noBean3);
        }
    }
}
