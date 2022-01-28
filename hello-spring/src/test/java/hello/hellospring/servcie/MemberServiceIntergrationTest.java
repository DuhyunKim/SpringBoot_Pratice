package hello.hellospring.servcie;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.transaction.Transactional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

@SpringBootTest
@Transactional //Test DB를 설정하거나 @Transactional 어노테이션을 주입하여 실제 commit 되게 하지 않는다.
public class MemberServiceIntergrationTest {

	@Autowired MemberService memberService;
	@Autowired MemberRepository memberRepository;

	/*
	@BeforeEach public void beforeEach() { 
		memberRepository = new
		MemoryMemberRepository(); memberService = new
	 	MemberService(memberRepository); } 
	 */
	
	// repository 초기화
	/*
	@AfterEach
	public void afterEach() {
		memberRepository.clearStore();
	}
	*/
	
	@Test
	public void testJoin() {
		//given
		Member member = new Member();                                                                                  	
		member.setName("hello");                                                                                       	
		                                                                                                               	
		//when                                                                                                         	
		Long saveId = memberService.join(member);                                                                      	
		                                                                                                               	
		//then                                                                                                         	
		Member findMember = memberService.findOne(saveId).get();                                                       	
		assertThat(member.getName()).isEqualTo(findMember.getName());                                                  	
	}                                                                                                                  	
                                                                                                                       	
	@Test                                                                                                              	
	public void testValidateDuplicateMember() {                                                                        	
		//given                                                                                                        	
		Member member1 = new Member();
		member1.setName("spring");
		
		Member member2 = new Member();
		member2.setName("spring");
		
		//when
		memberService.join(member1);
		IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
		
		assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
	}
	
	@Test
	public void testFindMembers() {
		
	}

	@Test
	public void testFindOne() {
	}

}
