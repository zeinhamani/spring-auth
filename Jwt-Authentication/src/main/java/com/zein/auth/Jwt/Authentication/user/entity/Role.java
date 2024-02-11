package com.zein.auth.Jwt.Authentication.user.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;


import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.zein.auth.Jwt.Authentication.user.entity.Permission.*;

@RequiredArgsConstructor
public enum Role {

	CUSTOMER(
			Set.of(
					CUSTOMER_PERMISSION
			)
	),
	AGENCY(
			Set.of(
					AGENCY_PERMISSION
			)
	),

	ADMIN(
			Set.of(
				ADMIN_PERMISSION,
					AGENCY_PERMISSION,
					CUSTOMER_PERMISSION
			)
	)
	;

	@Getter
	private final Set<Permission> permissions;

	public List<SimpleGrantedAuthority> getAuthorities(){
		var authorities = getPermissions()
				.stream()
				.map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
				.collect(Collectors.toList());
		//authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
		//return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + this.name()));
		return authorities;
	}
}
