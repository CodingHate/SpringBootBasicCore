package com.example.springbootbsiccore.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import static org.assertj.core.api.Assertions.*;

public class SingletonWithPrototypeTest1 {

    @Test
    public void prototypeFind(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototpyeBean.class);

        PrototpyeBean prototypeBean1 = ac.getBean(PrototpyeBean.class);
        prototypeBean1.addCount();
        assertThat(prototypeBean1.getCount()).isEqualTo(1);

        PrototpyeBean prototypeBean2 = ac.getBean(PrototpyeBean.class);
        prototypeBean2.addCount();
        assertThat(prototypeBean2.getCount()).isEqualTo(1);
    }

    @Test
    public void singletonClientUsePrototype(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(
                ClientBean.class,
                PrototpyeBean.class);

        ClientBean clientBean1 = ac.getBean(ClientBean.class);
        int count1 = clientBean1.logic();
        assertThat(count1).isEqualTo(1);

        ClientBean clientBean2 = ac.getBean(ClientBean.class);
        int count2 = clientBean2.logic();
        assertThat(count2).isEqualTo(2); // prototype 호출시 미리 주입된것을 가져오므로 초기값이 기존 수행된 값으로 가지게 된다.

    }

    @Scope("singleton")
    static class ClientBean{
        private final PrototpyeBean prototpyeBean; // 생성시점에 주입, 미리 기존 주입이 되어 있으면 그대로 사용하게 된다. 따라서 싱글톤으로 사용시 문제가 발생될수 있다.

        @Autowired
        public ClientBean(PrototpyeBean prototpyeBean) {
            this.prototpyeBean = prototpyeBean;
        }

        public int logic(){
            prototpyeBean.addCount();
            int count = prototpyeBean.getCount();
            return count;
        }
    }

    @Scope("prototype")
    static class PrototpyeBean{
        private int count =0;

        public void addCount(){
            count++;
        }

        public int getCount(){
            return count;
        }

        @PostConstruct
        public void init(){
            System.out.println("PrototpyeBean.init " + this );
        }

        @PreDestroy
        public void destroy(){
            System.out.println("PrototpyeBean.destroy 호출이 되지 않지만 사용");
        }

    }
}
