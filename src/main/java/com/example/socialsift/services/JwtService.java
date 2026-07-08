package com.example.socialsift.services;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.socialsift.entity.siftaccount;
import com.example.socialsift.repository.siftaccountrepository;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    private final siftaccountrepository repo;

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.exp}")
    private long exp;

    public JwtService(siftaccountrepository repo) {
        this.repo = repo;
    }

    public String generateToken(String email) {

        siftaccount user = repo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return Jwts.builder()
                .subject(email)
                .claim("role", user.getRole())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + exp))
                .signWith(getKey())
                .compact();
    }

    private SecretKey getKey() {
        return Keys.hmacShaKeyFor(
                secret.getBytes(java.nio.charset.StandardCharsets.UTF_8)
        );
    }

    public String extractUsername(String token) {
        return extractClaims(token).getSubject();
    }

    public Claims extractClaims(String token) {

        return Jwts.parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public boolean validateToken(String token,
            org.springframework.security.core.userdetails.UserDetails userDetails) {

        try {
            String username = extractUsername(token);

            Date expiration = extractClaims(token)
                    .getExpiration();

            return username.equals(userDetails.getUsername())
                    && expiration.after(new Date());

        } catch (Exception e) {

            System.out.println("JWT Validation Error : " + e.getMessage());

            return false;
        }
    }
}