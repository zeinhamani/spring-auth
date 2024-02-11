package com.zein.auth.Jwt.Authentication.user.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "agencies")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Agency extends User {

    private String agencyName;
    private String logo;
    private List<Long> phoneNums;
}
