package com.zein.auth.Jwt.Authentication.demo;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users/sec/v1/management")
public class ManagementDemo {

    @GetMapping
    @PreAuthorize("hasAnyAuthority('customer:perms','agency:perms')")
    public String get(){
        return "GET:: Management controller";
    }
    @PostMapping
    @PreAuthorize("hasAnyAuthority('customer:perms','agency:perms')")
    public String post(){
        return "POST:: Management controller";
    }
    @PutMapping
    @PreAuthorize("hasAuthority('agency:perms')")
    public String put(){
        return "PUT:: Management controller";
    }
    @DeleteMapping
    @PreAuthorize("hasAuthority('agency:perms')")
    public String delete(){
        return "DELETE:: Management controller";
    }
}
