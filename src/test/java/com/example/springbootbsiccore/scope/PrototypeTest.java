package com.example.springbootbsiccore.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class PrototypeTest {

    @Test
    public void prototypeBeanFind(){
        AnnotationConfigApplicationContext ac
                = new AnnotationConfigApplicationContext(PrototypeBean.class); // 자동으로 bean으로 등록이 된다.

        System.out.println("find prototypeBean1");
        PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
        System.out.println("find prototypeBean2");
        PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);

        System.out.printf("prototypeBean1 = " + prototypeBean1);
        System.out.printf("prototypeBean2 = " + prototypeBean2);

        Assertions.assertThat(prototypeBean1).isNotSameAs(prototypeBean2);

//        prototypeBean1.destroy(); 호출이 되지 않으므로 직접 호출을 해야 한다.
        ac.close();
    }

    @Scope("prototype")
    static class PrototypeBean{
        @PostConstruct
        public void init(){
            System.out.println("PrototypeBean.init");
        }

        @PreDestroy
        public void destroy(){
            // prototype은 호출이 되지 않는다.
            System.out.println("PrototypeBean.destroy");
        }
    }
}
