package com.zein.auth.Jwt.Authentication.user.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "customers")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer extends User {

    private String firstname;
    private String lastname;
    private String genre;
    private Integer numReser;
    private Number bonus;
}
