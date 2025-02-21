/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.medium.mediumposts.Entity;

import java.util.ArrayList;
import java.util.List;

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
 public class MediumPost {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer postid;

    private String title;

    private String content;

    @ElementCollection
    private List<Integer> contentid = new ArrayList<>();
}
