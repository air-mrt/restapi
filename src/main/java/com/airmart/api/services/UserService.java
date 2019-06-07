package com.airmart.api.services;

import com.airmart.api.domains.User;
import com.airmart.api.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {
    private UserRepo repository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    public UserService(UserRepo userRepo, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.repository = userRepo;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void save (User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setEnabled(1);
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
            return user;
        }
        throw new UsernameNotFoundException("User '" + username + "' not found");
    }
}

