/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.medium.mediumuser.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medium.mediumuser.Entity.MediumUser;
import com.medium.mediumuser.Repository.UserRepo;

/**
 *
 * @author ayushpuri
 */
@Service
 public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;
    
    @Override
    public MediumUser getUser(Integer userid) {
        return userRepo.findById(userid).get();
    }
    
    @Override
    public MediumUser saveUser(MediumUser user) {
        return userRepo.save(user);
    }

    @Override
    public String updateUser(MediumUser user) {
        
        Optional<MediumUser> user1 = userRepo.findById(user.getUserid());
        if(user1.isPresent()){
            userRepo.save(user);
            return "User updated successfully";
        }
        else return "User not found";
    }

    @Override
    public String deleteUser(Integer userid) {
        Optional<MediumUser> user = userRepo.findById(userid);
        if(user.isPresent()){
            userRepo.deleteById(userid);
            return "User deleted successfully";
        }
        else return "User not found";
    }

}
