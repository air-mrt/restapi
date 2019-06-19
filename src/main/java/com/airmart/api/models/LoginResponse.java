package com.airmart.api.models;

import lombok.Data;

import java.util.Date;

@Data
public class LoginResponse {
    String username;
    String token;
    Date expirationDate;
}
