package com.example.socialsift.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class influencerprofile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Social handle cannot be empty")
    @Size(min = 3, max = 50, message = "Social handle must be 3–50 characters")
    private String socialhandle;

    @NotBlank(message = "Primary platform cannot be empty")
    private String primaryplatform;

    @NotBlank(message = "Niche category cannot be empty")
    @Size(min = 3, max = 50, message = "Niche category must be 3–50 characters")
    private String nichecategory;

    @NotNull(message = "Follower count cannot be null")
    @Min(value = 0, message = "Follower count cannot be negative")
    private Long basefollowercount;

    private Double overallengagementscore;

    public influencerprofile() {
    }

    public influencerprofile(String socialhandle, String primaryplatform, String nichecategory,
                             Long basefollowercount, Double overallengagementscore) {
        this.socialhandle = socialhandle;
        this.primaryplatform = primaryplatform;
        this.nichecategory = nichecategory;
        this.basefollowercount = basefollowercount;
        this.overallengagementscore = overallengagementscore;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSocialhandle() {
        return socialhandle;
    }

    public void setSocialhandle(String socialhandle) {
        this.socialhandle = socialhandle;
    }

    public String getPrimaryplatform() {
        return primaryplatform;
    }

    public void setPrimaryplatform(String primaryplatform) {
        this.primaryplatform = primaryplatform;
    }

    public String getNichecategory() {
        return nichecategory;
    }

    public void setNichecategory(String nichecategory) {
        this.nichecategory = nichecategory;
    }

    public Long getBasefollowercount() {
        return basefollowercount;
    }

    public void setBasefollowercount(Long basefollowercount) {
        this.basefollowercount = basefollowercount;
    }

    public Double getOverallengagementscore() {
        return overallengagementscore;
    }

    public void setOverallengagementscore(Double overallengagementscore) {
        this.overallengagementscore = overallengagementscore;
    }
}