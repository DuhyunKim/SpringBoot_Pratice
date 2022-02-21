package com.jojoldu.book.springboot;

import com.jojoldu.book.springboot.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.is;

/*
테스트를 진행할 때 JUnit 내장된 실행자 외에 다른 실행자를 실행시킵니다.
즉, 스프링 부트 테스트와 JUnit 사이에 연결자 역할을 합니다.
*/
@RunWith(SpringRunner.class)
/*
선언할 경우 @Controller, @ControllerAdvice 등을 사용할 수 있습니다.
*/
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc; //웹 API 테스트할 때 사용합니다. 스프링 MVC 테스트의 시작점입니다.

    @Test
    public void Hello가_리턴된다() throws Exception {
        String hello = "hello";
        /*
            1. MockMVCC 통해 /hello 주로소 HTTP GET 요청을 합니다.
            2. HTTP Header 상태값 확인(200, 404, 500등)
            3. 응답 본문의 내용을 검증(String hello)
        */
        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;
        //jsonPath: JSON 응답값을 필드별로 검증할 수 있는 메소드
        mvc.perform(get("/hello/dto").param("name", name).param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}
