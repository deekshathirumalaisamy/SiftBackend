package com.example.socialsift.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class campaignengagement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Influencer ID cannot be null")
    private Integer influencerid;

    @NotNull(message = "Campaign ID cannot be null")
    private Integer campaignid;

    @NotBlank(message = "Status cannot be empty")
    private String status;

    @NotNull(message = "Total engagement score cannot be null")
    private Double totalengagementscore;

    @NotNull(message = "Payout amount cannot be null")
    private Double payoutamount;

    public campaignengagement() {
    }

    public campaignengagement(Integer influencerid, Integer campaignid, String status,
                              Double totalengagementscore, Double payoutamount) {
        this.influencerid = influencerid;
        this.campaignid = campaignid;
        this.status = status;
        this.totalengagementscore = totalengagementscore;
        this.payoutamount = payoutamount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInfluencerid() {
        return influencerid;
    }

    public void setInfluencerid(Integer influencerid) {
        this.influencerid = influencerid;
    }

    public Integer getCampaignid() {
        return campaignid;
    }

    public void setCampaignid(Integer campaignid) {
        this.campaignid = campaignid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getTotalengagementscore() {
        return totalengagementscore;
    }

    public void setTotalengagementscore(Double totalengagementscore) {
        this.totalengagementscore = totalengagementscore;
    }

    public Double getPayoutamount() {
        return payoutamount;
    }

    public void setPayoutamount(Double payoutamount) {
        this.payoutamount = payoutamount;
    }
}