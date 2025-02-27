/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.reddit_monolith.reddit_monolith.Security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.reddit_monolith.reddit_monolith.Entity.UserEntity;
import com.reddit_monolith.reddit_monolith.Repository.UserRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author ayushpuri
 */
@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> user = userRepository.findByUsername(username);
        if(user.isEmpty()){
            System.out.println("User Not Found at MyUserDetailService - loadUserByUsername");
            throw new UsernameNotFoundException("User Not Found at MyUserDetailService - loadUserByUsername");
        }
        return new UserPrincipal(user.get());
    }

}
