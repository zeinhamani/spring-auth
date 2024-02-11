package com.zein.auth.Jwt.Authentication.auth.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AgencyRequest {

    private String agencyName;

    private String logo;
    private List<Long> phoneNums;

    private String numTel;

    private String password;

}
