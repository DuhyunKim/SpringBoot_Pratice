package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

//JpaRepository<Posts, Long>의 Posts: Entity 클래스, Long: PK타입
public interface PostsRepository extends JpaRepository<Posts, Long> {
}
