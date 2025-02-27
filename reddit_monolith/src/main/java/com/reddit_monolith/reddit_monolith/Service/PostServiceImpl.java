/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.reddit_monolith.reddit_monolith.Service;

import java.util.List;
import java.util.Optional;

import com.reddit_monolith.reddit_monolith.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;

import com.reddit_monolith.reddit_monolith.DTO.post_Dto;
import com.reddit_monolith.reddit_monolith.Document.Post;
import org.springframework.stereotype.Service;

/**
 *
 * @author ayushpuri
 */
@Service
public class PostServiceImpl implements PostService{

    @Autowired
    public PostRepository postRepo;

    @Override
    public Post createPost(post_Dto post) {
        
        Post newpost = Post.builder()
                .title(post.getTitle())
                .content(post.getContent())
                .tags(post.getTags())
                .build();

        postRepo.save(newpost);        
        return newpost;
    }

    @Override
    public Optional<Post> getPost(String postId) {
        return postRepo.findById(postId);
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepo.findAll();
    }

    @Override
    public Post updatePost(String postId, post_Dto newpost) {
        Post oldPost = postRepo.findById(postId).get();
        oldPost.setTitle(newpost.getTitle());
        oldPost.setContent(newpost.getContent());
        oldPost.setTags(newpost.getTags());

        postRepo.save(oldPost);
        return oldPost;
    }

    @Override
    public String deletePost(String postId) {
        
        Optional<Post> tobeDeleted = postRepo.findById(postId);
        if(tobeDeleted.isPresent()){
            postRepo.deleteById(tobeDeleted.get().getPostid());
            return "Successfully deleted";
        }
        return "Post not found";

    }

}
