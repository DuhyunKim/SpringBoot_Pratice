package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.service.posts.PostsService;
import com.jojoldu.book.springboot.web.Dto.PostsResponseDto;
import com.jojoldu.book.springboot.web.Dto.PostsSaveRequestDto;
import com.jojoldu.book.springboot.web.Dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/*
* 스프링에서 Bean 주입받는 방식은 Autowired, setter, 생성자(권장)
* 해당 RequiredArgsConstructor(lombok)은 final이 선언된 모든 필드 인자값으로 하는 생성자 생성
* */
@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;
    // POST: 생성, PUT: 수정, GET:조회, Delete: 삭제
    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id){
        postsService.delete(id);
        return id;
    }

}
