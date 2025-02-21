/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.medium.mediumuser.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author ayushpuri
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table
public class MediumUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userid;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique=true)
    private String email;

    private String password;
    
    private Integer number;
}
