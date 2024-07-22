package com.blogapp12.service;

import com.blogapp12.payload.PostDto;

import java.util.List;

public interface PostService {
    public PostDto createPost(PostDto postDto);

    void deletePost(Long id);

    List<PostDto> fetchAllPost();
}
