package com.zein.auth.Jwt.Authentication.auth.service;

import com.zein.auth.Jwt.Authentication.auth.model.*;

import com.zein.auth.Jwt.Authentication.user.entity.*;
import com.zein.auth.Jwt.Authentication.auth.model.AdminRequest;
import com.zein.auth.Jwt.Authentication.auth.model.AgencyRequest;
import com.zein.auth.Jwt.Authentication.auth.model.CustomerRequest;
import com.zein.auth.Jwt.Authentication.user.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.zein.auth.Jwt.Authentication.config.JwtService;

import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

	private final UserRepository repository;


	
	private final PasswordEncoder passwordEncoder;
	
	private final JwtService jwtService;
	
	private final AuthenticationManager authenticateManager;

	/*public AuthenticationResponse register(RegisterRequest request) {
		var user = User.builder()
			.email(request.getEmail())
			.password(passwordEncoder.encode(request.getPassword()))
			.role(request.getRole())
			.build();
		repository.save(user);
		var jwtToken = jwtService.generateToken(user);
		return AuthenticationResponse.builder()
				.token(jwtToken)
				.build();
	}*/

	public AuthenticationResponse authenticate(AuthenticationRequest request) {
		authenticateManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						request.getNumTel(),
						request.getPassword()
						)
				);
		var user = repository.findByNumTel(request.getNumTel())
				.orElseThrow();

		var jwtToken = jwtService.generateToken(user);
		return AuthenticationResponse.builder()
				.token(jwtToken)
				.build();
	}

	public Customer registerCustomer(CustomerRequest customerRequest) {
		Customer customer = Customer.builder()
				.firstname(customerRequest.getFirstname())
				.lastname(customerRequest.getLastname())
				.genre(customerRequest.getGenre())
				.bonus(0)
				.numReser(0)
				.build();
		customer.setNumTel(customerRequest.getNumTel());
		customer.setPassword(passwordEncoder.encode(customerRequest.getPassword()));
		customer.setUserId(UUID.randomUUID().toString());
		customer.setRole(Role.CUSTOMER);

		Customer savedCustomer = repository.save(customer);

		return savedCustomer;
	}

	public Agency registerAgency(AgencyRequest agencyRequest) {
		Agency agency = Agency.builder()
				.agencyName(agencyRequest.getAgencyName())
				.logo(agencyRequest.getLogo())
				.phoneNums(agencyRequest.getPhoneNums())
				.build();
		agency.setNumTel(agencyRequest.getNumTel());
		agency.setPassword(passwordEncoder.encode(agencyRequest.getPassword()));
		agency.setUserId(UUID.randomUUID().toString());
		agency.setRole(Role.AGENCY);

		Agency savedAgency = repository.save(agency);
		return savedAgency;
	}

	public Admin registerAdmin(AdminRequest adminRequest) {
		Admin admin = Admin.builder()
				.name(adminRequest.getName())
				.build();
		admin.setNumTel(adminRequest.getNumTel());
		admin.setPassword(passwordEncoder.encode(adminRequest.getPassword()));
		admin.setUserId(UUID.randomUUID().toString());
		admin.setRole(Role.ADMIN);

		Admin savedAdmin = repository.save(admin);
		return savedAdmin;

	}

	private AuthenticationResponse haveToken(User user){
		repository.save(user);
		var jwtToken = jwtService.generateToken(user);
		return AuthenticationResponse.builder()
				.token(jwtToken)
				.build();
	}
}
