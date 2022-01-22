package hello.hellospring.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import hello.hellospring.domain.Member;

import static org.assertj.core.api.Assertions.*;

class MemoeyMemberRepository {
	
	MemoryMemberRepository repository = new MemoryMemberRepository();
	
	// repository 초기화
	@AfterEach
	public void afterEach() {
		repository.clearStore();
	}
	
	//테스트 함수 실행 순서는 무작위 
	@Test
	public void save() {
		Member member = new Member();
		member.setName("spring");
		
		repository.save(member);
		
		Member result = repository.findById(member.getId()).get();
		//Assertions.assertEquals(member, null);
		assertThat(result).isEqualTo(result);
	}
	
	@Test
	public void findByName() { 
		Member member1 = new Member();
		member1.setName("spring1");
		repository.save(member1);
		
		Member member2 = new Member();
		member2.setName("spring2");
		repository.save(member2);
		
		Member result = repository.findByName("spring2").get();
		assertThat(result).isEqualTo(member2);
		
	}
	
	@Test
	public void findAll() {
		
		Member member1 = new Member();
		member1.setName("spring1");
		repository.save(member1);
		
		Member member2 = new Member();
		member2.setName("spring2");
		repository.save(member2);
		
		List<Member> result = repository.findAll();
		
		assertThat(result.size()).isEqualTo(2);
		
	}
		
}
