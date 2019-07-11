package com.airmart.api.domains;

import com.airmart.api.config.ApiConstants;
import com.airmart.api.models.deserialize.DateDeserializer;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    private String message;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @NotNull(message = "Owner might be invalid or null")
    private User owner;
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = ApiConstants.DATE_PATTERN)
    @JsonDeserialize(using = DateDeserializer.class)
    private Date postedDate = new Date();
    @Transient
    private List<User> users;
    @OneToMany(mappedBy = "chat")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    private List<ChatMessage> messages;

    public Chat(Long id) {
        this.id = id;
    }
    public Chat(List<User> users){
        this.users = users;
    }
}