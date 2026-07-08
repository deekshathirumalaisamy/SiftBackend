package com.example.socialsift.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.socialsift.entity.influencerprofile;
import com.example.socialsift.services.influencerprofileservices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth/profile")
public class influencerprofilecontroller {

    private final influencerprofileservices ser;

    public influencerprofilecontroller(influencerprofileservices ser) {
        this.ser = ser;
    }

    @PostMapping
    public influencerprofile saveData(@Valid @RequestBody influencerprofile data) {
        return ser.saveData(data);
    }

    @GetMapping
    public List<influencerprofile> getData() {
        return ser.getAllData();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserData(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(ser.getUserDetails(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Profile not found");
        }
    }

    @PutMapping("/{id}")
    public influencerprofile updateData(@PathVariable Integer id, @RequestBody influencerprofile data) {
        return ser.updateDatabase(id, data);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> patchData(@PathVariable Integer id, @RequestBody influencerprofile data) {
        try {
            return ResponseEntity.ok(ser.patchData(id, data));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> getDeleteData(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(ser.getDelete(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Profile not found");
        }
    }
}