package com.example.Service;

import com.example.entity.Comment;
import com.example.entity.Post;
import com.example.payload.CommentDTO;
import com.example.repository.CommentRepository;
import com.example.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    public CommentDTO saveComment(long postId, CommentDTO commentDTO) {
        Post post = postRepository.findById(postId).get();

        Comment comment = new Comment();
        comment.setName(commentDTO.getName());
        comment.setEmail(commentDTO.getEmail());
        comment.setBody(commentDTO.getBody());
        comment.setPost(post);
        Comment newComment = commentRepository.save(comment);

        CommentDTO dto = new CommentDTO();
        dto.setCommentId(newComment.getCommentId());
        dto.setName(newComment.getName());
        dto.setEmail(newComment.getEmail());
        dto.setBody(newComment.getBody());


        return dto;
    }
}