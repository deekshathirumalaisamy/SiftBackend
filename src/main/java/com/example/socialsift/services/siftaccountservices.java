package com.example.socialsift.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.socialsift.entity.siftaccount;
import com.example.socialsift.repository.siftaccountrepository;

@Service
public class siftaccountservices {

    @Autowired
    private siftaccountrepository rep;

    @Autowired
    private PasswordEncoder encoder;

    public siftaccount saveData(siftaccount data) {

        if (rep.findByEmail(data.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        if (data.getPassword() == null || data.getPassword().isBlank()) {
            throw new IllegalArgumentException("Password cannot be empty");
        }

        data.setPassword(encoder.encode(data.getPassword()));

        return rep.save(data);
    }

    public List<siftaccount> getAllData() {
        return rep.findAll();
    }

    public siftaccount getUser(Integer id) {
        return rep.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public siftaccount update(Integer id, siftaccount data) {

        siftaccount old = getUser(id);

        old.setEmail(data.getEmail());

        if (data.getPassword() != null)
            old.setPassword(encoder.encode(data.getPassword()));

        old.setRole(data.getRole());

        if (data.getActive() != null)
            old.setActive(data.getActive());

        return rep.save(old);
    }

    public void delete(Integer id) {

        if (!rep.existsById(id)) {
            throw new RuntimeException("Account ID " + id + " not found");
        }

        rep.deleteById(id);
    }
}