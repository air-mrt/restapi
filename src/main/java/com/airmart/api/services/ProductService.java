package com.airmart.api.services;

import com.airmart.api.domains.Product;
import com.airmart.api.domains.User;
import com.airmart.api.repos.ProductRepo;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

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
    public boolean interestedInProduct(Long id, User user){
        if(repository.existsById(id)) {
            Product product = repository.findById(id).get();
            Set<User> set= product.getInterested();
            set.add(user);
            product.setInterested(set);
            repository.save(product);
            return true;
        }
        return false;
    }
    public boolean uninterestedInProduct(Long id, User user){
        if(repository.existsById(id)) {
            Product product = repository.findById(id).get();
            Set<User> set= product.getInterested();
            set.remove(user);
            product.setInterested(set);
            repository.save(product);
            return true;
        }
        return false;
    }
    public List<Product> getAll() {
        List<Product> all = (List<Product>) repository.findAll();
        Collections.reverse(all);
        return all;
    }
    public List<Product> search(BooleanExpression exp){
        return (List<Product>) repository.findAll(exp);
    }
    public List<Product> findAllInterestedByUser(User user){
        List<Product> all = new ArrayList<>();
        for (Product product:
                repository.findAll()) {
            if(product.getInterested().contains(user)){
                all.add(product);
            }
        }
        return all;
    }

}
