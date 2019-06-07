package com.airmart.api.services;

import com.airmart.api.domains.Product;
import com.airmart.api.domains.User;
import com.airmart.api.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepo repository;
    @Autowired
    private UserService userService;


    public Product save (Product product) {
        return repository.save(product);
    }


    public Product update(Product product) {
        return repository.save(product);
    }


    public void delete(Product product) {
        repository.delete(product);

    }
    public void deleteById(Long id) {
        repository.deleteById(id);
    }


    public Product getById(Long id) {
        if(repository.existsById(id)) {
            return repository.findById(id).get();
        }
        return null;

    }
    public List<Product> getByUsername(String username) {
       User user =userService.findUserByUsername(username);
       return repository.findAllByUser(user);

    }




    public List<Product> getAll() {
        List<Product> all = (List<Product>) repository.findAll();
        Collections.reverse(all);
        return all;
    }

}
