package com.airmart.api.repos;

import com.airmart.api.domains.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepo extends CrudRepository<Role, Long> {
    Role findByRole(String role);

}