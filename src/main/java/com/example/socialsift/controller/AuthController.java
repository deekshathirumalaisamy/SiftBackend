package com.example.socialsift.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.socialsift.entity.siftaccount;
import com.example.socialsift.repository.siftaccountrepository;
import com.example.socialsift.services.JwtService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authManager;
    private final JwtService jwtService;
    private final siftaccountrepository repo;
    private final PasswordEncoder encoder;

    public AuthController(AuthenticationManager authManager, JwtService jwtService, siftaccountrepository repo, PasswordEncoder encoder) {
        this.authManager = authManager;
        this.jwtService = jwtService;
        this.repo = repo;
        this.encoder = encoder;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody siftaccount user) {
        try {
            if (repo.findByEmail(user.getEmail()).isPresent()) {
                return ResponseEntity.status(HttpStatus.CONFLICT)
                        .body(Map.of("message", "Email already exists"));
            }

            user.setPassword(encoder.encode(user.getPassword()));

            siftaccount saved = repo.save(user);
            saved.setPassword(null);

            return ResponseEntity.status(HttpStatus.CREATED).body(saved);

        } catch (Exception e) {
            Map<String, Object> error = new HashMap<>();
            error.put("message", "Registration failed: " + e.getMessage());

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody siftaccount user) {
        try {
            authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            user.getEmail(),
                            user.getPassword()
                    )
            );

            String token = jwtService.generateToken(user.getEmail());

            Map<String, Object> res = new HashMap<>();
            res.put("message", "Login Success");
            res.put("token", token);

            return ResponseEntity.ok(res);

        } catch (Exception e) {
            Map<String, Object> res = new HashMap<>();
            res.put("error", e.getMessage());

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(res);
        }
    }
}