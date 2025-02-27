package com.reddit_monolith.reddit_monolith.Controller;

import com.reddit_monolith.reddit_monolith.DTO.UserEntityDto;
import com.reddit_monolith.reddit_monolith.Service.UserEntityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserEntityServiceImpl userService;

    @GetMapping("")
    public UserEntityDto findMyDetails(){
        if(userService.getUser().isPresent()){
            return userService.getUser().get();
        }
        else return null;
    }

    @DeleteMapping("")
    public String deleteUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        return userService.deleteUser(username);
    }

    @PutMapping("")
    public UserEntityDto updateUser(@RequestBody UserEntityDto user){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        return userService.updateUser(username, user);
    }



}
