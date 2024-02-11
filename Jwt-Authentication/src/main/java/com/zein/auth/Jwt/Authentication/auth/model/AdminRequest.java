package com.zein.auth.Jwt.Authentication.auth.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminRequest {

    private String name;

    private String numTel;

    private String password;

}
