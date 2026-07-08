package com.example.socialsift.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.socialsift.entity.campaignengagement;
import com.example.socialsift.repository.campaignengagementrepository;

@Service
public class campaignengagementservices {

    @Autowired
    campaignengagementrepository rep;

    public campaignengagement saveData(campaignengagement data) {
        return rep.save(data);
    }

    public List<campaignengagement> getAllData() {
        return rep.findAll();
    }

    public campaignengagement getUserDetails(Integer id) {
        return rep.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Engagement not found"));
    }

    public campaignengagement updateDatabase(Integer id, campaignengagement data) {

        campaignengagement old = rep.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Engagement not found"));

        old.setInfluencerid(data.getInfluencerid());
        old.setCampaignid(data.getCampaignid());
        old.setStatus(data.getStatus());
        old.setTotalengagementscore(data.getTotalengagementscore());
        old.setPayoutamount(data.getPayoutamount());

        return rep.save(old);
    }

    public campaignengagement patchData(Integer id, campaignengagement data) {

        campaignengagement oldData = rep.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Engagement not found"));

        if (data.getInfluencerid() != null) {
            oldData.setInfluencerid(data.getInfluencerid());
        }

        if (data.getCampaignid() != null) {
            oldData.setCampaignid(data.getCampaignid());
        }

        if (data.getStatus() != null) {
            oldData.setStatus(data.getStatus());
        }

        if (data.getTotalengagementscore() != null) {
            oldData.setTotalengagementscore(data.getTotalengagementscore());
        }

        if (data.getPayoutamount() != null) {
            oldData.setPayoutamount(data.getPayoutamount());
        }

        return rep.save(oldData);
    }

    public campaignengagement getDelete(Integer id) {

        campaignengagement data = rep.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Engagement not found"));

        rep.delete(data);

        return data;
    }
}