package com.example.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class CommentDTO {

    private Long commentId;

    private String name;

    private String email;

    private String body;



}
