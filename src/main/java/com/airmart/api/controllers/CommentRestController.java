package com.airmart.api.controllers;

import com.airmart.api.config.JwtTokenProvider;
import com.airmart.api.domains.Comment;
import com.airmart.api.domains.Product;
import com.airmart.api.services.CommentService;
import com.airmart.api.services.ProductService;
import com.airmart.api.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping(path = "/api/comments", produces="application/json" )
public class CommentRestController {

    @Autowired
    ProductService productService;
    @Autowired
    CommentService commentService;
    @Autowired
    UserService userService;
    @Autowired
    JwtTokenProvider jwtTokenProvider;
    ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping()
    public ResponseEntity<List<Comment>> getAllCommentsForProduct(@RequestParam(name = "productId" ,required=true)Long productId){
        return new ResponseEntity<>(commentService.getByProductId(productId), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable("id") Long id){
        Comment comment = commentService.getById(id);
        if(comment != null) {
            return new ResponseEntity<>(comment,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/auth/{id}")
    public ResponseEntity<Comment> deleteCommentById(@PathVariable("id") Long id,
                                                     @RequestHeader(value = "Authorization" ,required = true ) String bearerToken){
        try {
            //First check if the comment was posted by the same user
            String usernameLoggedIn = jwtTokenProvider.getUsername(bearerToken.substring(7, bearerToken.length()));
            Comment commentToBeDeleted = commentService.getById(id);
            String usernameCommentOwner = commentToBeDeleted.getUser().getUsername();

            if(usernameLoggedIn.contentEquals(usernameCommentOwner)){
                commentService.deleteById(id);
                return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
            }

        }
        catch(EmptyResultDataAccessException e) {
        }
        return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST); }

    @PostMapping(path = "/auth",consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Comment save(@RequestBody Comment comment,
                        @RequestParam(name = "productId", required = true)Long productId,
                        @RequestHeader(value = "Authorization" ,required = true ) String bearerToken) {
        String username = jwtTokenProvider.getUsername(bearerToken.substring(7, bearerToken.length()));
        comment.setUser(userService.findUserByUsername(username));
        comment.setProduct(productService.getById(productId));
        return commentService.save(comment);
    }


}
