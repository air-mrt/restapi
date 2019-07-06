package com.airmart.api.repos;


import com.airmart.api.domains.Product;
import com.airmart.api.domains.User;

import com.mysema.query.types.expr.StringExpression;
import com.mysema.query.types.path.StringPath;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepo extends CrudRepository<Product, Long>{
    List<Product> findAllByUser(User user);
}