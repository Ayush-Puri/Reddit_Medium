/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.medium.mediumposts.Repository;

import com.medium.mediumposts.Entity.MediumPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ayushpuri
 */
@Repository
 public interface MediumPostRepo extends JpaRepository<MediumPost, Integer> {

}
