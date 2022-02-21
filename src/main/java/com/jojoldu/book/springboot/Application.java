package com.jojoldu.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//프로젝트의 메인 클래스(스프링 부트의 자동 설정, 스프링 Bean 읽기와 생서을 모두 자동으로 설정, 해당 파일 위치부터 설정을 읽음)
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        //내장 WAS를 실행
        SpringApplication.run(Application.class, args);
    }
}
