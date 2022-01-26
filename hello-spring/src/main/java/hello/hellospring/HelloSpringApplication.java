package hello.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * 객체 빈 추가 설정 시 기본적으로 'HelloSpringApplication' 하위 폴더에 있는 클래스이어야 한다.
 * */
@SpringBootApplication
public class HelloSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringApplication.class, args);
	}

}
