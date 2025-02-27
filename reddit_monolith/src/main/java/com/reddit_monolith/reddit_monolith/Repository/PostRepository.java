/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.reddit_monolith.reddit_monolith.Repository;
import com.reddit_monolith.reddit_monolith.Document.Comment;
import com.reddit_monolith.reddit_monolith.Document.Reply;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.reddit_monolith.reddit_monolith.Document.Post;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ayushpuri
 */
@Repository
public interface PostRepository extends MongoRepository<Post, String>{
    @Transactional
    @Modifying
    @Query(value = "{'_id': ?0}", update = "{'$push': {'comments': ?1}}")
    void addComment(String postId, Comment comment);

    // ✅ Add a Reply to a specific Comment
    @Transactional
    @Modifying
    @Query(value = "{'_id': ?0, 'comments.commentId': ?1}",
            update = "{'$push': {'comments.$.replies': ?2}}")
    void addReply(String postId, String commentId, Reply reply);
}
