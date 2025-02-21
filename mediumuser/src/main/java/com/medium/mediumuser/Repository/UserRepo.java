/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.medium.mediumuser.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medium.mediumuser.Entity.MediumUser;

/**
 *
 * @author ayushpuri
 */
@Repository
 public interface UserRepo extends JpaRepository<MediumUser, Integer> {


}
