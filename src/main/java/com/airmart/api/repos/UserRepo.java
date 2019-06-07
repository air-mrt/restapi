package com.airmart.api.repos;


import com.airmart.api.domains.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long> {
    User findByUsername(String username);

}