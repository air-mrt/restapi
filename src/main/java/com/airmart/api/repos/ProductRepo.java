package com.airmart.api.repos;


import com.airmart.api.domains.Product;
import com.airmart.api.domains.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepo extends CrudRepository<Product, Long> {
    List<Product> findAllByUser(User user);

}