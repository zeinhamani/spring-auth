package com.zein.auth.Jwt.Authentication.user.controller;

import com.zein.auth.Jwt.Authentication.user.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users/customers")
public class CustomerController {
    @Autowired
    private CustomerService service;


}
