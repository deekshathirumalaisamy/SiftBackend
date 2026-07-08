package com.example.socialsift.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.socialsift.entity.influencerprofile;
import com.example.socialsift.repository.influencerprofilerepository;

@Service
public class influencerprofileservices {

    @Autowired
    influencerprofilerepository rep;

    public influencerprofile saveData(influencerprofile data) {
        return rep.save(data);
    }

    public List<influencerprofile> getAllData() {
        return rep.findAll();
    }

    public influencerprofile getUserDetails(Integer id) {
        return rep.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Profile not found"));
    }

    public influencerprofile updateDatabase(Integer id, influencerprofile data) {

        influencerprofile old = rep.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Profile not found"));

        old.setSocialhandle(data.getSocialhandle());
        old.setPrimaryplatform(data.getPrimaryplatform());
        old.setNichecategory(data.getNichecategory());
        old.setBasefollowercount(data.getBasefollowercount());
        old.setOverallengagementscore(data.getOverallengagementscore());

        return rep.save(old);
    }

    public influencerprofile patchData(Integer id, influencerprofile data) {

        influencerprofile old = rep.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Profile not found"));

        if (data.getSocialhandle() != null) {
            old.setSocialhandle(data.getSocialhandle());
        }

        if (data.getPrimaryplatform() != null) {
            old.setPrimaryplatform(data.getPrimaryplatform());
        }

        if (data.getNichecategory() != null) {
            old.setNichecategory(data.getNichecategory());
        }

        if (data.getBasefollowercount() != null) {
            old.setBasefollowercount(data.getBasefollowercount());
        }

        if (data.getOverallengagementscore() != null) {
            old.setOverallengagementscore(data.getOverallengagementscore());
        }

        return rep.save(old);
    }

    public influencerprofile getDelete(Integer id) {

        influencerprofile data = rep.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Profile not found"));

        rep.delete(data);

        return data;
    }
}