/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.medium.mediumuser.Contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.medium.mediumuser.Entity.MediumUser;
import com.medium.mediumuser.Service.UserService;


/**
 *
 * @author ayushpuri
 */
@RestController
@RequestMapping("/MediumUser")
 public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{userid}")
    public MediumUser getMethodName(@RequestParam Integer userid) {
        return userService.getUser(userid);
    }

    @PostMapping("/user")
    public MediumUser postMethodName(@RequestBody MediumUser entity) {
        return userService.saveUser(entity);         
    }

    @PutMapping("/user/{userid}")
    public String putMethodName(@PathVariable String userid, @RequestBody MediumUser entity) {
        return userService.updateUser(entity);
    }

    @DeleteMapping("/user/{userid}")
    public String deleteMethodName(@RequestParam Integer userid) {
        return userService.deleteUser(userid);
    }    

}
