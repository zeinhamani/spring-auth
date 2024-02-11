package com.zein.auth.Jwt.Authentication.user.controller;

import com.zein.auth.Jwt.Authentication.auth.model.AdminRequest;
import com.zein.auth.Jwt.Authentication.user.entity.Admin;
import com.zein.auth.Jwt.Authentication.user.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users/admin")

public class AdminController {
    @Autowired
    private AdminService service;


}
