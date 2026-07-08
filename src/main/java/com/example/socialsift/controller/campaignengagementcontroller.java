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

import com.example.socialsift.entity.campaignengagement;
import com.example.socialsift.services.campaignengagementservices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth/engagement")
public class campaignengagementcontroller {

    private final campaignengagementservices ser;

    public campaignengagementcontroller(campaignengagementservices ser) {
        this.ser = ser;
    }

    @PostMapping
    public ResponseEntity<?> saveData(@Valid @RequestBody campaignengagement data) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(ser.saveData(data));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping
    public List<campaignengagement> getData() {
        return ser.getAllData();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserData(@PathVariable int id) {
        try {
            return ResponseEntity.ok(ser.getUserDetails(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Engagement not found");
        }
    }

    @PutMapping("/{id}")
    public campaignengagement updateData(@PathVariable Integer id, @RequestBody campaignengagement data) {
        return ser.updateDatabase(id, data);
    }

    @PatchMapping("/{id}")
    public campaignengagement patchData(@PathVariable Integer id, @RequestBody campaignengagement data) {
        return ser.patchData(id, data);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> getDeleteData(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(ser.getDelete(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Engagement not found");
        }
    }
}