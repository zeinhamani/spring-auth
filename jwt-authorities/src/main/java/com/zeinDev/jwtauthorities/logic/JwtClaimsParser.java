package com.zeinDev.jwtauthorities.logic;

import io.jsonwebtoken.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class JwtClaimsParser {

    Jwt<?,?> jwtObject;
    public JwtClaimsParser(String jwt,String secretToken){
        this.jwtObject = parseJwt(jwt,secretToken);
    }

    private Jwt<?,?> parseJwt(String jwtString, String secretToken) {
        byte[] secretKeyBytes = Base64.getEncoder().encode(secretToken.getBytes());
        SecretKey signingKey = new SecretKeySpec(secretKeyBytes, SignatureAlgorithm.HS256.getJcaName());

        JwtParser jwtParser = Jwts.parserBuilder()
                .setSigningKey(signingKey)
                .build();
        return jwtParser.parse(jwtString);
    }

    public Collection<? extends GrantedAuthority> getUserAuthorities(){
        Collection<Map<String,String>> scopes = ((Claims) jwtObject.getBody()).get("scope", List.class);
        return scopes.stream()
                .map(scopeMap -> new SimpleGrantedAuthority(scopeMap.get("authority")))
                .collect(Collectors.toList());
    }

    public String getJwtSubject(){
        return  ((Claims) jwtObject.getBody()).getSubject();
    }
}
