package com.example.socialsift.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.socialsift.entity.marketingcampaign;

@Repository
public interface marketingcampaignrepository extends JpaRepository<marketingcampaign, Integer> {

}