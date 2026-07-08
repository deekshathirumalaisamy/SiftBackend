package com.example.socialsift.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.socialsift.entity.influencerprofile;

@Repository
public interface influencerprofilerepository extends JpaRepository<influencerprofile, Integer> {

}