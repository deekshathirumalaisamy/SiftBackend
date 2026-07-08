package com.example.socialsift.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.socialsift.entity.marketingcampaign;
import com.example.socialsift.repository.marketingcampaignrepository;

@Service
public class marketingcampaignservices {

    @Autowired
    marketingcampaignrepository rep;

    public marketingcampaign saveData(marketingcampaign data) {
        return rep.save(data);
    }

    public List<marketingcampaign> getAllData() {
        return rep.findAll();
    }

    public marketingcampaign getUserDetails(Integer id) {
        return rep.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Campaign not found"));
    }

    public marketingcampaign updateDatabase(Integer id, marketingcampaign data) {

        marketingcampaign old = rep.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Campaign not found"));

        old.setTitle(data.getTitle());
        old.setDescription(data.getDescription());
        old.setBudgetallocation(data.getBudgetallocation());
        old.setTargetplatform(data.getTargetplatform());
        old.setStatus(data.getStatus());

        return rep.save(old);
    }

    public marketingcampaign patchData(Integer id, marketingcampaign data) {

        marketingcampaign old = rep.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Campaign not found"));

        if (data.getTitle() != null)
            old.setTitle(data.getTitle());

        if (data.getDescription() != null)
            old.setDescription(data.getDescription());

        if (data.getTargetplatform() != null)
            old.setTargetplatform(data.getTargetplatform());

        if (data.getStatus() != null)
            old.setStatus(data.getStatus());

        if (data.getBudgetallocation() != 0)
            old.setBudgetallocation(data.getBudgetallocation());

        return rep.save(old);
    }

    public marketingcampaign getDelete(Integer id) {

        marketingcampaign data = rep.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Campaign not found"));

        rep.delete(data);

        return data;
    }
}