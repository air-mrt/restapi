package com.airmart.api.domains;

import com.sun.istack.internal.NotNull;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@Entity
@Table(name="product",schema="airmart")
public class Product{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotBlank( message="title not be blank")
    private String title;
    @NotNull
    private String price;
    @NotNull
    @Lob
    @NotBlank( message="Description must be not be blank")
    private String description;
    private Date createdAt = new Date();
    @ManyToOne
    private  User user;
    private String picturePath;

    @PrePersist
    void createdAt() {
        this.createdAt = new Date();
    }




}
