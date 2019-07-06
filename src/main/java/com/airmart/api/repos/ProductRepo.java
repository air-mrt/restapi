package com.airmart.api.repos;


import com.airmart.api.domains.Product;
import com.airmart.api.domains.QProduct;
import com.airmart.api.domains.User;


import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;
import org.springframework.data.repository.CrudRepository;


import java.util.List;

public interface ProductRepo extends CrudRepository<Product, Long>, QuerydslPredicateExecutor<Product>, QuerydslBinderCustomizer<QProduct>{
    List<Product> findAllByUser(User user);
    @Override
    default public void customize(QuerydslBindings bindings, QProduct root){
        bindings.bind(String.class)
                .first((SingleValueBinding<StringPath,String>) StringExpression::containsIgnoreCase);
        bindings.excluding(root.interested);
        bindings.excluding(root.picturePath);
        bindings.excluding(root.id);
        bindings.excluding(root.createdAt);
        bindings.excluding(root.user);
    }
}