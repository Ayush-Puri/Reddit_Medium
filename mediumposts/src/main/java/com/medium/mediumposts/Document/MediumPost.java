package com.medium.mediumposts.Document;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import lombok.Builder;
import lombok.Data;

/**
 *
 * @author ayushpuri
 */
@Data
@Builder
@Document(indexName = "mediumpost")
 public class MediumPost {
    
    @Id
    private Integer postid;
    private String title;
    private String content;
    private LocalDateTime createdAt = LocalDateTime.now();

}
