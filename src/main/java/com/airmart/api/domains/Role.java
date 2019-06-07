package com.airmart.api.domains;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor(access= AccessLevel.PRIVATE, force=true)
@RequiredArgsConstructor
@Table(name="role",schema="airmart")
public class Role {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private final Long id;
    private String role;

}
