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

import com.example.socialsift.entity.engagementmetriclog;
import com.example.socialsift.services.engagementmetriclogservices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth/metric")
public class engagementmetriclogcontroller {

    private final engagementmetriclogservices ser;

    public engagementmetriclogcontroller(engagementmetriclogservices ser) {
        this.ser = ser;
    }

    @PostMapping
    public engagementmetriclog saveData(@Valid @RequestBody engagementmetriclog data) {
        return ser.saveData(data);
    }

    @GetMapping
    public List<engagementmetriclog> getData() {
        return ser.getAllData();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserData(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(ser.getUserDetails(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Metric not found");
        }
    }

    @PutMapping("/{id}")
    public engagementmetriclog updateData(@PathVariable Integer id, @RequestBody engagementmetriclog data) {
        return ser.updateDatabase(id, data);
    }

    @PatchMapping("/{id}")
    public engagementmetriclog patchData(@PathVariable Integer id, @RequestBody engagementmetriclog data) {
        return ser.patchData(id, data);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> getDeleteData(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(ser.getDelete(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Metric not found");
        }
    }
}