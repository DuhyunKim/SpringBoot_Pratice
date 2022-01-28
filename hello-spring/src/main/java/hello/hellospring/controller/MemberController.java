package hello.hellospring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import hello.hellospring.domain.Member;
import hello.hellospring.servcie.MemberService;

/**
 * 
 * @author du_hy
 * 스프링 빈을 등록하는 2가지 방법
 * 1. 컴포넌트 스캔과 자동 의존 관계 설정
 * 2. 자바 코드로 직접 스프링 빈 등록하기
 */
@Controller //컴포넌트 스캔
public class MemberController {
	
	private final MemberService memberService;

	/* DI 방식 중 필드 주입 
	 * @Autowired final MemberService memberService;
	 */
	
	/* DI 방식 중 setter
	 * @Autowired  
	 * public setMemberController(MemberService
	 * memberService) { this.memberService = memberService; }
	 */ 

	@Autowired //의존관계 설정, DI 방식 중 생성자 주입(권장)
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	} 
	
	@GetMapping("/members/new")
	public String createForm() {
		return "members/createMemberForm";
		
	}
	
	@PostMapping("/members/new")
	public String create(MemberForm form) {
		Member member = new Member();
		member.setName(form.getName());
		
		memberService.join(member);
		
		return "redirect:/";
		
	}
	
	@GetMapping("/members")
	public String lisg(Model model) {
		List<Member> members = memberService.findMembers();
		model.addAttribute("members", members);
		
		return "members/memberList";
		
	}
}
