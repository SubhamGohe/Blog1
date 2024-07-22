package com.blogapp12.controller;

import com.blogapp12.payload.PostDto;
import com.blogapp12.service.PostService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/posts")
public class PostController {

    private PostService postService;

    public PostController(PostService postService)
    {

        this.postService = postService;
    }

    //http://localhost:8080/api/posts
    @PostMapping
    public ResponseEntity<?> createPost(@Valid @RequestBody PostDto postDto, BindingResult bindingResult )
    {
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getFieldError().getDefaultMessage() ,HttpStatus.INTERNAL_SERVER_ERROR);
        }


        PostDto dto = postService.createPost(postDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    //http://localhost:8080/api/posts/2
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePost(@PathVariable Long id)
    {
        postService.deletePost(id);
        return new ResponseEntity<>("Post Id Delete !",HttpStatus.OK);
    }
    //locslhost:8080
     @GetMapping
     public ResponseEntity<List<PostDto>> fetchAllPost(){
         List<PostDto> postDtos = postService.fetchAllPost();
         return new ResponseEntity<>(postDtos,HttpStatus.OK);

     }
     //httplocalhost:8080/api/posts?pageNo=0&pagesixe= 5




}




//if (postDto.getTitle().length()<3){
//        return new ResponseEntity<>("title Should be atlest 3 characters",HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//
//        if (postDto.getDescription().length()<10){
//        return new ResponseEntity<>("Description Should be atlest 10 characters",HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//PostDto dto = postService.createPost(postDto);
//        return new ResponseEntity<>(dto, HttpStatus.CREATED);
//        }