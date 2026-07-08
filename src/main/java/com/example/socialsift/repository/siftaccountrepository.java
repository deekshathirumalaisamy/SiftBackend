package com.example.socialsift.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.socialsift.entity.siftaccount;

@Repository
public interface siftaccountrepository extends JpaRepository<siftaccount, Integer> {

    Optional<siftaccount> findByEmail(String email);
}