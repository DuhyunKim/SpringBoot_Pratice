package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.web.Dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*RestController: 컨트롤러를 JSON을 반환하는 컨트롤러로 만들준다(@ResponseBody 사용하지 않아도 됨)*/
@RestController 
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name,
                                     @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }
}
