/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.reddit_monolith.reddit_monolith.DTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author ayushpuri
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
 public class post_Dto {

    private String title;
    private String content;
    private List<String> tags;

}
