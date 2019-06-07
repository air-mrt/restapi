package com.airmart.api.domains;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@Entity
@Table(name="comment",schema="airmart")
public class Comment {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private  Long id;
    @NotBlank(message="Content should not be blank")
    private String content;
    private Date createdAt = new Date();
    @ManyToOne
    private Product product;
    @ManyToOne
    private  User user;


}