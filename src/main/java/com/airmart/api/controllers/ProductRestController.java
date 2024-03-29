package com.airmart.api.controllers;

import com.airmart.api.config.JwtTokenProvider;
import com.airmart.api.config.ProductPredicatesBuilder;
import com.airmart.api.domains.Product;
import com.airmart.api.domains.User;
import com.airmart.api.models.ProductResponse;
import com.airmart.api.services.FileStorageService;
import com.airmart.api.services.ProductService;
import com.airmart.api.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.querydsl.core.types.dsl.BooleanExpression;
import io.jsonwebtoken.JwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@CrossOrigin(origins="*")
@RestController
@RequestMapping(path = "/api/products", produces="application/json" )
public class ProductRestController {
    @Autowired
    ProductService productService;
    @Autowired
    FileStorageService fileStorageService;
    @Autowired
    JwtTokenProvider jwtTokenProvider;
    @Autowired
    UserService userService;
    ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping(path = "/auth", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ProductResponse> postProduct(
            @RequestParam(value="productJson", required = true ) String productJson,
            @RequestParam(required = false, value="image") MultipartFile file,
            @RequestHeader(value = "Authorization" ,required = true ) String bearerToken)
            throws IOException {
        try{
            String  fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/products/downloadImage/").path("no_image.png").toUriString();
            if(file != null){
                String fileName = fileStorageService.storeFile(file);
                fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/products/downloadImage/").path(fileName).toUriString();
            }

            Product product = objectMapper.readValue(productJson,Product.class);
            product.setPicturePath(fileDownloadUri);
            String username = jwtTokenProvider.getUsername(bearerToken.substring(7, bearerToken.length()));
            product.setUser(userService.findUserByUsername(username));
            productService.save(product);
            return new ResponseEntity<>(ProductResponse.convertToProductResponse(product),HttpStatus.CREATED);
        }
        catch(JwtException e) {
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }
    @PatchMapping(path = "/auth/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ProductResponse> patchProduct(
            @PathVariable("id") Long id,
            @RequestParam(value="productJson", required = true ) String productJson,
            @RequestParam(required = false, value="image") MultipartFile file,
            @RequestHeader(value = "Authorization" ,required = true ) String bearerToken)
            throws IOException {
        try{
            String  fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/products/downloadImage/").path(productService.getById(id).getPicturePath()).toUriString();
            if(file != null){
                String fileName = fileStorageService.storeFile(file);
                fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/products/downloadImage/").path(fileName).toUriString();
            }

            Product product = objectMapper.readValue(productJson,Product.class);
            product.setPicturePath(fileDownloadUri);
            String username = jwtTokenProvider.getUsername(bearerToken.substring(7, bearerToken.length()));
            product.setUser(userService.findUserByUsername(username));
            product.setId(id);
            productService.save(product);
            return new ResponseEntity<>(ProductResponse.convertToProductResponse(product),HttpStatus.CREATED);
        }
        catch(JwtException e) {
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping(path = "/interested/{id}")
    public ResponseEntity<ProductResponse> interestedInProduct(@PathVariable("id") Long id,
                                                       @RequestHeader(value = "Authorization" ,required = true ) String bearerToken) {
        try{
            Product product = productService.getById(id);
            String username = jwtTokenProvider.getUsername(bearerToken.substring(7, bearerToken.length()));
            User user = userService.findUserByUsername(username);
            if(productService.interestedInProduct(id,user)){
                return new ResponseEntity<>(ProductResponse.convertToProductResponse(product),HttpStatus.OK);
            }
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
        catch(JwtException e) {
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }


    }
    @PostMapping(path = "/uninterested/{id}")
    public ResponseEntity<ProductResponse> uninterestedInProduct(@PathVariable("id") Long id,
                                                               @RequestHeader(value = "Authorization" ,required = true ) String bearerToken) {
        try{
            Product product = productService.getById(id);
            String username = jwtTokenProvider.getUsername(bearerToken.substring(7, bearerToken.length()));
            User user = userService.findUserByUsername(username);
            if(productService.uninterestedInProduct(id,user)){
                return new ResponseEntity<>(ProductResponse.convertToProductResponse(product),HttpStatus.OK);
            }
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
        catch(JwtException e) {
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }


    }
    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts(){
            return new ResponseEntity<>(ProductResponse.convertToProductResponse(productService.getAll()),HttpStatus.OK);
        }

    @GetMapping("/user")
    public ResponseEntity<List<ProductResponse>> getAllProductsUser(@RequestHeader(value = "Authorization" ,required = true ) String bearerToken
            ){
        String username = jwtTokenProvider.getUsername(bearerToken.substring(7, bearerToken.length()));
        return new ResponseEntity<>(ProductResponse.convertToProductResponse(productService.getByUsername(username)),HttpStatus.OK);

    }
    @GetMapping("/interested")
    public ResponseEntity<List<ProductResponse>> getAllInterestedProducts(
            @RequestHeader(value = "Authorization" ,required = true ) String bearerToken){
        String username = jwtTokenProvider.getUsername(bearerToken.substring(7, bearerToken.length()));
        User user = userService.findUserByUsername(username);
        return new ResponseEntity<>(ProductResponse.convertToProductResponse(productService.findAllInterestedByUser(user)),HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<ProductResponse>> searchProducts(
            @RequestParam(value="keyword") String search){
       ProductPredicatesBuilder builder = new ProductPredicatesBuilder();

        if (search != null) {
            Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
            Matcher matcher = pattern.matcher(search + ",");
            while (matcher.find()) {
                builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
            }
        }
        BooleanExpression exp = builder.build();
        return new ResponseEntity<>(ProductResponse.convertToProductResponse(productService.search(exp)),HttpStatus.OK);

    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable("id") Long id){
       Product product = productService.getById(id);
        if(product != null) {
            return new ResponseEntity<>(ProductResponse.convertToProductResponse(product),HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/auth/{id}")
    public ResponseEntity<ProductResponse> deleteProductById(@PathVariable("id") Long id,
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
    @GetMapping("/downloadImage/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request){
        Resource resource  = fileStorageService.loadFileAsResource(fileName);
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
        if(contentType == null) {
            contentType = "application/octet-stream";
        }
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, String.format("attachment;filename=\"%s\"", resource.getFilename()))
                .body(resource);
    }
}
