package com.example.springbootbsiccore.singletone;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();
    public static SingletonService getInstance(){
        return instance;
    }

    private SingletonService(){} // 외부에서 생성할 수 없도록 private로 지정

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}
