package com.airmart.api.domains;

import lombok.Data;

@Data
public class AuthBody {
    private String username;
    private String password;
}
