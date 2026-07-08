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

import com.example.socialsift.entity.siftaccount;
import com.example.socialsift.services.siftaccountservices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth/account")
public class siftaccountcontroller {

    private final siftaccountservices ser;

    public siftaccountcontroller(siftaccountservices ser) {
        this.ser = ser;
    }

    @PostMapping
    public ResponseEntity<siftaccount> saveData(@Valid @RequestBody siftaccount data) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ser.saveData(data));
    }

    @GetMapping
    public ResponseEntity<List<siftaccount>> getData() {
        return ResponseEntity.ok(ser.getAllData());
    }

    @GetMapping("/{id}")
    public ResponseEntity<siftaccount> getUser(@PathVariable Integer id) {
        return ResponseEntity.ok(ser.getUser(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<siftaccount> update(@PathVariable Integer id, @Valid @RequestBody siftaccount data) {
        return ResponseEntity.ok(ser.update(id, data));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<siftaccount> patch(@PathVariable Integer id, @RequestBody siftaccount data) {
        return ResponseEntity.ok(ser.update(id, data));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            ser.delete(id);
            return ResponseEntity.ok("Account deleted successfully with ID : " + id);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }
}