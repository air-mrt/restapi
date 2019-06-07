package com.airmart.api.controllers;

import com.airmart.api.config.JwtTokenProvider;
import com.airmart.api.domains.Product;
import com.airmart.api.services.FileStorageService;
import com.airmart.api.services.ProductService;
import com.airmart.api.services.UserService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import static org.springframework.http.ResponseEntity.badRequest;
import static org.springframework.http.ResponseEntity.noContent;
import io.jsonwebtoken.JwtException;
import java.io.IOException;
import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping(path = "/api/products", produces="application/json" )
public class ProductRestController {
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;
    @Autowired
    FileStorageService fileStorageService;
    @Autowired
    JwtTokenProvider jwtTokenProvider;
    ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping(path = "/auth", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Product> postProduct(
            @RequestParam(value="productJson", required = true ) String productJson,
            @RequestParam(required = true, value="file") MultipartFile file,
            @RequestHeader(value = "Authorization" ,required = true ) String bearerToken)
            throws IOException {
        try{
            String fileName = fileStorageService.storeFile(file);
            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/product/downloadImage/").path(fileName).toUriString();
            Product product = objectMapper.readValue(productJson,Product.class);
            product.setPicturePath(fileDownloadUri);
            String username = jwtTokenProvider.getUsername(bearerToken.substring(7, bearerToken.length()));
            product.setUser(userService.findUserByUsername(username));
            productService.save(product);
            return new ResponseEntity<>(product,HttpStatus.CREATED);
        }
        catch(JwtException e) {
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }


    }
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        return new ResponseEntity<>(productService.getAll(),HttpStatus.OK);

    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id){
       Product product = productService.getById(id);
        if(product != null) {
            return new ResponseEntity<>(product,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/auth/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Product> deleteProductById(@PathVariable("id") Long id,
                                                        @RequestHeader(value = "Authorization" ,required = true ) String bearerToken){
        try {
            //First check if the product was posted by the same user
            String usernameLoggedIn = jwtTokenProvider.getUsername(bearerToken.substring(7, bearerToken.length()));
            Product productToBeDeleted = productService.getById(id);
            String usernameProductOwner = productToBeDeleted.getUser().getUsername();

            if(usernameLoggedIn.contentEquals(usernameProductOwner)){
                productService.deleteById(id);
                return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
            }

        }
        catch(EmptyResultDataAccessException e) {
        }
        return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST); }
}
