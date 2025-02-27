package com.reddit_monolith.reddit_monolith.Controller;

import com.reddit_monolith.reddit_monolith.DTO.UserEntityDto;
import com.reddit_monolith.reddit_monolith.Service.UserEntityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private UserEntityServiceImpl userService;

    @PostMapping("/signup")
    private String signUp(@RequestBody UserEntityDto user){
        return userService.saveUser(user);
    }

}
