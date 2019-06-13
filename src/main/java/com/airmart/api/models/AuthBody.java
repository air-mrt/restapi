package com.airmart.api.models;

import lombok.Data;

@Data
public class AuthBody {
    private String username;
    private String password;
}
