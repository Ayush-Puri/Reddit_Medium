package com.reddit_monolith.reddit_monolith.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserEntityDto {
    private String name;

    private String email;

    private String username;

    private String password;

    private Long phonenumber;
}
