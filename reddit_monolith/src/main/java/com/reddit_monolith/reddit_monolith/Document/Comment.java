package com.reddit_monolith.reddit_monolith.Document;



import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "comment")
public class Comment {
      @Id
    private String id;
    private Integer authorId;
    private String content;
    private LocalDateTime createdOn;
    private List<Reply> replies;


}
