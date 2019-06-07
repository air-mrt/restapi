package com.airmart.api.repos;

import com.airmart.api.domains.Comment;
import com.airmart.api.domains.Product;
import com.airmart.api.domains.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepo extends CrudRepository<Comment, Long> {
    List<Comment> findAllByProduct(Product product);
    List<Comment> findAllByUser(User user);

}