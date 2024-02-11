package com.zein.auth.Jwt.Authentication.user.controller;


import com.zein.auth.Jwt.Authentication.auth.model.AgencyRequest;
import com.zein.auth.Jwt.Authentication.user.entity.Agency;
import com.zein.auth.Jwt.Authentication.user.service.AgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users/agencies")
public class AgencyController {

    @Autowired
    private AgencyService service;

    @PostMapping("/register")
    public ResponseEntity register(
            @RequestBody AgencyRequest agencyRequest){
        Agency agency =  service.register(agencyRequest);
        if (agency == null){
            return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
