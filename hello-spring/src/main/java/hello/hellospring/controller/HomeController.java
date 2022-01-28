package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import hello.hellospring.domain.Member;
import hello.hellospring.servcie.MemberService;

@Controller
public class HomeController {
	
	@GetMapping("/") //조회 시 src/main/resources/static/index.html 보다 우선순위 1순위
	public String home() {
		return "home";
	}
	
}
