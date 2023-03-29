package com.example.controller;

import com.example.Service.CommentService;
import com.example.payload.CommentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
public class CommentController {


    private CommentService commentService;
    private CommentDTO commentDTO;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    //http://localhost:8080/api/posts/1/comments
    @PostMapping("{postId}/comments")
    public ResponseEntity<CommentDTO> saveComment(@PathVariable long postId, @RequestBody CommentDTO commentDTO) {
        this.commentDTO = commentDTO;
        CommentDTO dto = commentService.saveComment(postId , commentDTO);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
}
