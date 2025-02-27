package com.reddit_monolith.reddit_monolith.Service;

import com.reddit_monolith.reddit_monolith.DTO.UserEntityDto;
import com.reddit_monolith.reddit_monolith.Entity.UserEntity;
import com.reddit_monolith.reddit_monolith.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserEntityServiceImpl implements UserEntityService {

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserEntity> getAllUsers(UserEntityDto user) {
        return userRepository.findAll();
    }

    @Override
    public String saveUser(UserEntityDto user){

        Optional<UserEntity> checkUsername = userRepository.findByUsername(user.getUsername());
        if(checkUsername.isPresent()){
            return "Signup Failed - Username Already Exists";
        }

        Optional<UserEntity> checkEmail = userRepository.findByEmail(user.getEmail());
        if(checkEmail.isPresent()){
            return "Signup Failed - Email Already Exists";
        }

        Optional<UserEntity> checkPhone = userRepository.findByNumber(user.getPhonenumber());
        if(checkPhone.isPresent()){
            return "Signup Failed - User with same Phone number Already Exists";
        }

        UserEntity newUser = UserEntity.builder()
                .email(user.getEmail())
                .name(user.getName())
                .number(user.getPhonenumber())
                .username(user.getUsername())
                .password(encoder.encode(user.getPassword()))
                .build();

        userRepository.save(newUser);
        return "Signup Successful";
    }

    @Override
    public UserEntityDto updateUser(String username, UserEntityDto user){

        UserEntity oldUser = userRepository.findByUsername(username).get();

        if(!oldUser.getUsername().equals(user.getUsername())){
            Optional<UserEntity> checkUsername = userRepository.findByUsername(user.getUsername());
            if(checkUsername.isPresent()){
                throw new RuntimeException("Update Failed - Username Already Exists");
            }else {
                oldUser.setUsername(user.getUsername());
            }
        }

        if(!oldUser.getEmail().equals(user.getEmail())){
            Optional<UserEntity> checkEmail = userRepository.findByEmail(user.getEmail());
            if(checkEmail.isPresent()){
                throw new RuntimeException("Update Failed - Email Already Exists");
            }
        }

        if(!oldUser.getNumber().equals(user.getPhonenumber())){
            Optional<UserEntity> checkPhone = userRepository.findByNumber(user.getPhonenumber());
            if(checkPhone.isPresent()){
                throw new RuntimeException("Update Failed - User with same Phone number Already Exists");
            }
            else oldUser.setNumber(user.getPhonenumber());
        }
        else {

            oldUser.setName(user.getName());
            oldUser.setPassword(encoder.encode(user.getPassword()));
            userRepository.save(oldUser);
        }
        return user;
    }


    @Override
    public Optional<UserEntityDto> getUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Optional<UserEntity> user = userRepository.findByUsername(username);
        return user.map(userEntity -> UserEntityDto.builder()
               .email(userEntity.getEmail())
                .name(userEntity.getName())
                .phonenumber(userEntity.getNumber())
                .username(userEntity.getUsername())
                .build()).or(() -> Optional.ofNullable(null));
    }

    @Override
    public String deleteUser(String username){
        Optional<UserEntity> user = userRepository.findByUsername(username);
        if(user.isPresent()){
            userRepository.deleteById(user.get().getUserid());
            return "Successfully Deleted";
        }
        return "Deletion Failed";
    }

}
