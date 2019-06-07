package com.airmart.api.services;

import com.airmart.api.domains.Role;
import com.airmart.api.domains.User;
import com.airmart.api.repos.RoleRepo;
import com.airmart.api.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService implements UserDetailsService {
    private UserRepo repository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private RoleRepo roleRepo;
    @Autowired
    public UserService(UserRepo userRepo, RoleRepo roleRepo,BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.repository = userRepo;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.roleRepo = roleRepo;
    }

    public void save (User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setEnabled(1);
        Role userRole = roleRepo.findByRole("USER");
        user.setRoles(new HashSet<>(Arrays.asList(userRole)));
        repository.save(user);
    }

    public User update(User user) {
        return repository.save(user);
    }


    public void delete(User user) {
        repository.delete(user);

    }


    public User findUserByUsername(String username) {
        return repository.findByUsername(username);
    }


    public List<User> getAll() {
        List<User> all = (List<User>) repository.findAll();
        return all;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUsername(username);

        if(user != null) {
            List<GrantedAuthority> authorities = getUserAuthority(user.getRoles());
            return buildUserForAuthentication(user, authorities);
        }
        throw new UsernameNotFoundException("User '" + username + "' not found");
    }

    private List<GrantedAuthority> getUserAuthority(Set<Role> userRoles) {
        Set<GrantedAuthority> roles = new HashSet<>();
        userRoles.forEach((role) -> {
            roles.add(new SimpleGrantedAuthority(role.getRole()));
        });

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
        return grantedAuthorities;
    }

    private UserDetails buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
    }
}

