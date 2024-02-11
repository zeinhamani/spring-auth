package com.zein.auth.Jwt.Authentication.user.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {
    ADMIN_PERMISSION("admin:perms"),
    AGENCY_PERMISSION("agency:perms"),


    CUSTOMER_PERMISSION("customer:perms"),

    ;

    @Getter
    private final String permission;
}
