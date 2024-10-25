package com.Practice.Web.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JWTService {

    private String secretKey = "asdf1234";

    public String generateToken(String username) {
        Map <String , Object> claims = new HashMap<>();

        return Jwts.builder()
                .claims()
                .add(claims)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 60 * 60 * 30))
                .and()
                .signWith(getKey())
                .compact();
    }

    private Key getKey() {
        byte[] keyBytes = java.util.Base64.getDecoder().decode(secretKey); // Corrected the Base64 decoding
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String extractUserName(String token) {
        return "";
    }
}
