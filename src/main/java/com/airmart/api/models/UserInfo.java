package com.airmart.api.models;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class UserInfo {
    private String name;
    private String username;
    private String phone;
    private String email;
    private String profilePicture;
    private String numberOfPosts;

}
