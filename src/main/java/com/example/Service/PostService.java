package com.example.Service;

import com.example.entity.Post;
import com.example.payload.PostDTO;
import com.example.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public PostDTO save(PostDTO postDTO){
        Post post = new Post();
        post.setTitle(postDTO.getTitle());
        post.setDescription(postDTO.getDescription());
        post.setContent(postDTO.getContent());
        Post newPost = postRepository.save(post);

        PostDTO dto = new PostDTO();
        dto.setPostId(newPost.getPostId());
        dto.setTitle(newPost.getTitle());
        dto.setDescription(newPost.getDescription());
        dto.setContent(newPost.getContent());
        return dto;
    }
}