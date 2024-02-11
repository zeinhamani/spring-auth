package com.zein.auth.Jwt.Authentication.auth.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerRequest {
    private String firstname;
    private String lastname;
    private String genre;


    private String numTel;

    private String password;

}
