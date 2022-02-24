package com.jojoldu.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//롬복의 어노테이션 @NoArgsConstructor: 기본 생성자 자동 추가
@Getter
@NoArgsConstructor
/*JPA의 어노테이션, 테이블과 링크될 클래스 ex)SalesManget.java -> sales_manager table
* Entity 클래스 기준으로 테이블이 생성되고 스키마가 변경되다.
* */
@Entity
public class Posts {
    @Id //해당 테이블의 PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK의 생성규칙
    private Long id;

    @Column(length = 500, nullable = false) //굳이 선언하지 않아도 되나 기본값 외에 추가로 변경이 필요한 옵션이 생길 시 사용
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;
    
    //@Setter을 사용하지 않고 DB에 삽입 시 @Builder를 통해 제공되는 빌더 클래스를 사용
    @Builder //해당클래스의 빌더 패턴 클래스 성성, 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
