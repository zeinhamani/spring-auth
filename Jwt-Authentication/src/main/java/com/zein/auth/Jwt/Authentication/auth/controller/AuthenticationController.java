package com.zein.auth.Jwt.Authentication.auth.controller;

import com.zein.auth.Jwt.Authentication.auth.service.AuthenticationService;
import com.zein.auth.Jwt.Authentication.auth.model.*;
import com.zein.auth.Jwt.Authentication.user.entity.Admin;
import com.zein.auth.Jwt.Authentication.user.entity.Agency;
import com.zein.auth.Jwt.Authentication.user.entity.Customer;
import com.zein.auth.Jwt.Authentication.auth.model.AdminRequest;
import com.zein.auth.Jwt.Authentication.auth.model.AgencyRequest;
import com.zein.auth.Jwt.Authentication.auth.model.CustomerRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users/auth")
@RequiredArgsConstructor
public class AuthenticationController {

	private final AuthenticationService service;


	@PostMapping("/register-customer")
	public ResponseEntity registerCustomer(
			@RequestBody CustomerRequest customerRequest){
		Customer customer =  service.registerCustomer(customerRequest);
		if (customer == null){
			return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity(HttpStatus.CREATED);
	}
	@PostMapping("/register-agency")
	public ResponseEntity registerAgency(
			@RequestBody AgencyRequest agencyRequest){
		Agency agency =  service.registerAgency(agencyRequest);
		if (agency == null){
			return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity(HttpStatus.CREATED);
	}
	@PostMapping("/register-admin")
	public ResponseEntity registerAdmin(
			@RequestBody AdminRequest adminRequest){
		Admin admin =  service.registerAdmin(adminRequest);
		if (admin == null){
			return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity(HttpStatus.CREATED);
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationResponse> authenticate(
			@RequestBody AuthenticationRequest request){
		return ResponseEntity.ok(service.authenticate(request));
	}
	
}
