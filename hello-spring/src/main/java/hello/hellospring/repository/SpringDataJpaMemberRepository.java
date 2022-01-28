package hello.hellospring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import hello.hellospring.domain.Member;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository{
	/*
	 * org.springframework.data.jpa.repository.JpaRepository 라이브러리 안에
	 * JpaMemberRepository 클래스 파일에서 사용하는 함수 중 아래 함수를 제외하고 같은 이름의 함수를 제공
	 * 아래 처럼 제공하지 않을 시 아래 함수처럼 정의해줘야한다.
	 */
	@Override
	Optional<Member> findByName(String name);
	
	
}
