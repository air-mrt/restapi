package com.airmart.api.services;

import com.airmart.api.domains.Comment;
import com.airmart.api.domains.Product;
import com.airmart.api.domains.User;
import com.airmart.api.repos.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepo commentRepo;
    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;

    public Comment save (Comment Comment) {
        return commentRepo.save(Comment);
    }
    public Comment update(Comment Comment) {
        return commentRepo.save(Comment);
    }
    public void delete(Comment Comment) {
        commentRepo.delete(Comment);

    }
    public void deleteById(Long id) {
        commentRepo.deleteById(id);
    }

    public Comment getById(Long id) {
        if(commentRepo.existsById(id)) {
            return commentRepo.findById(id).get();
        }
        return null;
    }
    public List<Comment> getByUsername(String username) {
        User user = userService.findUserByUsername(username);
        return commentRepo.findAllByUser(user);
    }
    public List<Comment> getByProductId(Long productId) {
        Product product = productService.getById(productId);
        return commentRepo.findAllByProduct(product);
    }
    public List<Comment> getAll() {
        List<Comment> all = (List<Comment>) commentRepo.findAll();
        Collections.reverse(all);
        return all;
    }
}
