/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.reddit_monolith.reddit_monolith.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reddit_monolith.reddit_monolith.Entity.UserEntity;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ayushpuri
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    Optional<UserEntity> findByUsername(String username);

    Optional<UserEntity> findByEmail(String email);

    Optional<UserEntity> findByNumber(Long phonenumber);
}
