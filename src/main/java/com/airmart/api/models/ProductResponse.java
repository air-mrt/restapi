package com.airmart.api.models;

import com.airmart.api.domains.Product;
import com.airmart.api.domains.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

@Data
@AllArgsConstructor
public class ProductResponse {
    private Long _id;
    private String username;
    private String title;
    private String price;
    private String description;
    private String pictureUrl;
    private String createdAt;
    private Set<String> interested;

    public static List<ProductResponse> convertToProductResponse(List<Product> products){
        List<ProductResponse> productResponses = new ArrayList<ProductResponse>();
        for(Product product:products){
            productResponses.add(new ProductResponse(product.getId(),product.getUser().getUsername(),product.getTitle(),product.getPrice(),product.getDescription(),product.getPicturePath(),product.getCreatedAt().toString(),convertToStringSet(product.getInterested())));
        }
        return productResponses;
    }
    public static  ProductResponse convertToProductResponse(Product product){
        return new ProductResponse(product.getId(),product.getUser().getUsername(),product.getTitle(),product.getPrice(),product.getDescription(),product.getPicturePath(),product.getCreatedAt().toString(),convertToStringSet(product.getInterested()));
    }
    private static Set<String> convertToStringSet(Set<User> userSet){
        Set<String> stringSet = new HashSet<>(Arrays.asList());
        if(userSet != null){
        for(User user:userSet){
            stringSet.add(user.getUsername());
        }
        }
        return stringSet;
    }
}
