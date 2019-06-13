package com.airmart.api.models;

import lombok.Data;

@Data
public class LoginResponse {
    String username;
    String token;
}
