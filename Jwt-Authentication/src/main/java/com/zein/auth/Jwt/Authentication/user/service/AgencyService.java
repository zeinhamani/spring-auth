package com.zein.auth.Jwt.Authentication.user.service;

import com.zein.auth.Jwt.Authentication.auth.model.AgencyRequest;
import com.zein.auth.Jwt.Authentication.user.entity.Agency;
import com.zein.auth.Jwt.Authentication.user.entity.Role;
import com.zein.auth.Jwt.Authentication.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AgencyService {

    @Autowired
    private UserRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public Agency register(AgencyRequest agencyRequest) {
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
}
