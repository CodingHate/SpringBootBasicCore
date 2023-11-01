package com.example.springbootbsiccore.lifecycle;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @Test
    public void lifeCycleTest(){
       ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClinet clinet = ac.getBean(NetworkClinet.class);
        ac.close();
    }

    @Configuration
    static class LifeCycleConfig{
        @Bean(initMethod = "init", destroyMethod = "closef")
        public NetworkClinet networkClinet(){
            NetworkClinet networkClinet = new NetworkClinet();
            networkClinet.setUrl("http://hello-spring.dev");
            return networkClinet;
        }
    }
}
