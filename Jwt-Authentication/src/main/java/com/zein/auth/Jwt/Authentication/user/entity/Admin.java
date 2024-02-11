package com.zein.auth.Jwt.Authentication.user.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "admins")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Admin extends User {

    private String name;
}
