package com.reddit_monolith.reddit_monolith.Service;

import com.reddit_monolith.reddit_monolith.DTO.UserEntityDto;
import com.reddit_monolith.reddit_monolith.Entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserEntityService {

    List<UserEntity> getAllUsers(UserEntityDto user);

    String saveUser(UserEntityDto user);

    UserEntityDto updateUser(String username, UserEntityDto user);

    Optional<UserEntityDto> getUser();

    String deleteUser(String username);
}
