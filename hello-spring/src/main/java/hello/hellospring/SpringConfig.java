package hello.hellospring;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.JpaMemberRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.servcie.MemberService;

/**
 * 
 * @author du_hy
 * 자바 코드로 직접 스프링 빈 등록하기
 * 참고: 빈 설정 방식 중 XML로 설정하는 방식도 있지만 최근에는 잘 사용하지 않는다.
 * 개방-폐쇄 원칙(OCP): 확장에는 열려있고 수정,변경에는 닫혀있다.
 */
@Configuration
public class SpringConfig {
//	
//	EntityManager em;
//	
//	@Autowired
//	public SpringConfig(EntityManager em) {
//		this.em = em;
//	}
//	
	private final MemberRepository memberRepository;
	
	@Autowired
	public SpringConfig(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	
	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository);
	}
	/* 자기 자신인 TimeTraceAop를 생성하는 코드가 되어서 순환참조 문제가 발생합니다.
	 * 만약 아래 함수를 사용 시에는  아래 클래스의 @Around 조건을 변경해야합니다.
	 * @Bean public TimeTraceAop timeTraceAop() { return new TimeTraceAop(); }
	 */
//			
//	@Bean
//	public MemberRepository memberRepository() {
//		//return new MemoryMemberRepository(); java 메모리
//		//return new JpaMemberRepository(em);
//	}

}
