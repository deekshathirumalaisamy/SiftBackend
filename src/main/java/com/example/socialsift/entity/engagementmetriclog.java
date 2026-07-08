package com.example.socialsift.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class engagementmetriclog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Engagement ID cannot be null")
    private Integer engagementid;

    @NotBlank(message = "Metric type cannot be empty")
    private String metrictype;

    @NotNull(message = "Numeric value cannot be null")
    private Double numericvalue;

    @NotNull(message = "Anomaly flag cannot be null")
    private Boolean anomalydetected;

    public engagementmetriclog() {
    }

    public engagementmetriclog(Integer engagementid, String metrictype, Double numericvalue, Boolean anomalydetected) {
        this.engagementid = engagementid;
        this.metrictype = metrictype;
        this.numericvalue = numericvalue;
        this.anomalydetected = anomalydetected;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEngagementid() {
        return engagementid;
    }

    public void setEngagementid(Integer engagementid) {
        this.engagementid = engagementid;
    }

    public String getMetrictype() {
        return metrictype;
    }

    public void setMetrictype(String metrictype) {
        this.metrictype = metrictype;
    }

    public Double getNumericvalue() {
        return numericvalue;
    }

    public void setNumericvalue(Double numericvalue) {
        this.numericvalue = numericvalue;
    }

    public Boolean getAnomalydetected() {
        return anomalydetected;
    }

    public void setAnomalydetected(Boolean anomalydetected) {
        this.anomalydetected = anomalydetected;
    }
}