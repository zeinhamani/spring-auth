package com.zein.auth.Jwt.Authentication.demo;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users/sec/v1/admin")
public class AdminDemo {

    @GetMapping
    @PreAuthorize("hasAuthority('admin:perms')")
    public String get(){
        return "GET:: admin controller";
    }
    @PostMapping
    @PreAuthorize("hasAuthority('admin:perms')")
    public String post(){
        return "POST:: admin controller";
    }
    @PutMapping
    @PreAuthorize("hasAuthority('admin:perms')")
    public String put(){
        return "PUT:: admin controller";
    }
    @DeleteMapping
    @PreAuthorize("hasAuthority('admin:perms')")
    public String delete(){
        return "DELETE:: admin controller";
    }
}
