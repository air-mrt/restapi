package com.airmart.api.domains;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
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

    @ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinTable(name="user_role",
            joinColumns= {@JoinColumn(name="user_id")},
            inverseJoinColumns= {@JoinColumn(name="role_id")})
    private Set<Role> roles;
    private String profilePicture;

    @OneToMany(mappedBy="owner")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    //@JsonDeserialize(using = ChatListDeserializer.class)
    private List<Chat> chats = new ArrayList<>();

    public User(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Set<GrantedAuthority> authorities = roles
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getRole()))
                .collect(Collectors.toSet());

        return authorities;
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

