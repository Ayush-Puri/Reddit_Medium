/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.reddit_monolith.reddit_monolith.Service;

import java.util.List;
import java.util.Optional;

import com.reddit_monolith.reddit_monolith.DTO.post_Dto;
import com.reddit_monolith.reddit_monolith.Document.Post;

/**
 *
 * @author ayushpuri
 */
public interface PostService {

    public Post createPost(post_Dto post);
    public Optional<Post> getPost(String postId);
    public List<Post> getAllPosts();
    public Post updatePost(String postId, post_Dto post);
    public String deletePost(String postId);

}
