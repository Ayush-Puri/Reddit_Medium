package com.reddit_monolith.reddit_monolith.Document;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

/**
 *
 * @author ayushpuri
 */
@Data
@Builder
@Document(collection = "post")
public class Post {
    
    @Id
    private String postid;
    private String title;
    private String content;
    private Integer authorId;
    private LocalDateTime createdAt;
    private List<String> tags;
    private List<Comment> comments;
}
