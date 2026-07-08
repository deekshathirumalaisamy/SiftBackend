package com.example.socialsift.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.socialsift.entity.engagementmetriclog;

@Repository
public interface engagementmetriclogrepository extends JpaRepository<engagementmetriclog, Integer> {

}