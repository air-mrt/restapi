package com.airmart.api.controllers;

import com.airmart.api.domains.Product;
import com.airmart.api.services.FileStorageService;
import com.airmart.api.services.ProductService;
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

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping(path = "/api/product", produces="application/json" )
public class ProductRestController {
    @Autowired
    ProductService productService;
    @Autowired
    FileStorageService fileStorageService;
    ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Product postProduct(
            @RequestParam(value="productJson", required = true ) String productJson,
            @RequestParam(required = true, value="file") MultipartFile file)
            throws JsonParseException, JsonMappingException, IOException {
        String fileName = fileStorageService.storeFile(file);
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/product/downloadImage/").path(fileName).toUriString();
       Product product = objectMapper.readValue(productJson,Product.class);
       product.setPicturePath(fileDownloadUri);
       productService.save(product);

        return product;

    }
    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id){
       Product product = productService.getById(id);
        if(product != null) {
            return new ResponseEntity<>(product,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProductById(@PathVariable("id") Long id){
        try {
           productService.deleteById(id);
        }
        catch(EmptyResultDataAccessException e) {

        }

    }
}
