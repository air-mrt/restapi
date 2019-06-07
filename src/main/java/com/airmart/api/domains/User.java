package com.airmart.api.domains;

import com.sun.istack.internal.NotNull;
import lombok.Data;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Collection;

@Data
@Entity
@Table(name="user",schema="airmart")
public class User implements UserDetails {

    /**
     *
     */
    private static final long serialVersionUID = 228223283460503633L;

    @Id
    @NotBlank(message = "Please provide a username")
    private String username;

    @Size(min = 8, message = "Your password must have at least 8 characters")
    @NotBlank(message = "Please provide your password")
    private String password;

    @NotBlank(message = "Please provide your full name")
    private String name;
    @NotBlank(message = "Please provide your full name")
    private String email;


    @NotBlank(message="Phone number is required")
    private String phone;
    @Column(name = "enabled")
    private int enabled;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
