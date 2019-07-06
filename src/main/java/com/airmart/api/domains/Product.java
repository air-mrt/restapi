package com.airmart.api.domains;

import com.sun.istack.internal.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor(access= AccessLevel.PRIVATE, force=true)
@RequiredArgsConstructor
@Table(name="product",schema="airmart")
public class Product {

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
    @ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinTable(name="product_user",
            joinColumns= {@JoinColumn(name="product_id")},
            inverseJoinColumns= {@JoinColumn(name="user_id")})
    private Set<User> interested;
    private String picturePath;

    @PrePersist
    void createdAt() {
        this.createdAt = new Date();
    }




}
