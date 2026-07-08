package com.example.socialsift.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.socialsift.entity.engagementmetriclog;
import com.example.socialsift.repository.engagementmetriclogrepository;

@Service
public class engagementmetriclogservices {

    @Autowired
    engagementmetriclogrepository rep;

    public engagementmetriclog saveData(engagementmetriclog data) {
        return rep.save(data);
    }

    public List<engagementmetriclog> getAllData() {
        return rep.findAll();
    }

    public engagementmetriclog getUserDetails(Integer id) {
        return rep.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Metric not found"));
    }

    public engagementmetriclog updateDatabase(Integer id, engagementmetriclog data) {

        engagementmetriclog old = rep.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Metric not found"));

        old.setEngagementid(data.getEngagementid());
        old.setMetrictype(data.getMetrictype());
        old.setNumericvalue(data.getNumericvalue());
        old.setAnomalydetected(data.getAnomalydetected());

        return rep.save(old);
    }

    public engagementmetriclog patchData(Integer id, engagementmetriclog data) {

        engagementmetriclog old = rep.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Metric not found"));

        if (data.getEngagementid() != null) {
            old.setEngagementid(data.getEngagementid());
        }

        if (data.getMetrictype() != null) {
            old.setMetrictype(data.getMetrictype());
        }

        if (data.getNumericvalue() != null) {
            old.setNumericvalue(data.getNumericvalue());
        }

        if (data.getAnomalydetected() != null) {
            old.setAnomalydetected(data.getAnomalydetected());
        }

        return rep.save(old);
    }

    public engagementmetriclog getDelete(Integer id) {

        engagementmetriclog data = rep.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Metric not found"));

        rep.delete(data);

        return data;
    }
}