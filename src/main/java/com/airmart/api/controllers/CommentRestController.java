package com.airmart.api.controllers;

import com.airmart.api.config.JwtTokenProvider;
import com.airmart.api.domains.Comment;
import com.airmart.api.models.CommentResponse;
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
    public ResponseEntity<List<CommentResponse>> getAllCommentsForProduct(@RequestParam(name = "productId" ,required=true)Long productId){
        return new ResponseEntity<>(CommentResponse.convertToCommentResponse(commentService.getByProductId(productId)), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CommentResponse> getCommentById(@PathVariable("id") Long id){
        Comment comment = commentService.getById(id);
        if(comment != null) {
            return new ResponseEntity<>(CommentResponse.convertToCommentResponse(comment),HttpStatus.OK);
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
    public ResponseEntity<Comment> save(@RequestParam(name = "comment", required = true) String comment,
                        @RequestParam(name = "productId", required = true)Long productId,
                        @RequestHeader(value = "Authorization" ,required = true ) String bearerToken) {
        Comment commentObj = new Comment();
        String username = jwtTokenProvider.getUsername(bearerToken.substring(7, bearerToken.length()));
        commentObj.setUser(userService.findUserByUsername(username));
        commentObj.setProduct(productService.getById(productId));
        commentObj.setContent(comment);
        commentService.save(commentObj);
        return new ResponseEntity<>(commentObj,HttpStatus.CREATED);
    }


}
