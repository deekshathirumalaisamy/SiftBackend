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

import com.example.socialsift.entity.marketingcampaign;
import com.example.socialsift.services.marketingcampaignservices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth/campaign")
public class marketingcampaigncontroller {

    private final marketingcampaignservices ser;

    public marketingcampaigncontroller(marketingcampaignservices ser) {
        this.ser = ser;
    }

    @PostMapping
    public ResponseEntity<?> saveData(@Valid @RequestBody marketingcampaign data) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(ser.saveData(data));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }

    @GetMapping
    public List<marketingcampaign> getData() {
        return ser.getAllData();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        marketingcampaign data = ser.getUserDetails(id);

        if (data == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Campaign not found");
        }

        return ResponseEntity.ok(data);
    }

    @PutMapping("/{id}")
    public marketingcampaign updateData(@PathVariable Integer id, @RequestBody marketingcampaign data) {
        return ser.updateDatabase(id, data);
    }

    @PatchMapping("/{id}")
    public marketingcampaign patchData(@PathVariable Integer id, @RequestBody marketingcampaign data) {
        return ser.patchData(id, data);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteData(@PathVariable Integer id) {
        marketingcampaign deleted = ser.getDelete(id);

        if (deleted == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Campaign not found");
        }

        return ResponseEntity.ok(deleted);
    }
}