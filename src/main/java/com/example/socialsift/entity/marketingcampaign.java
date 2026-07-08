package com.example.socialsift.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class marketingcampaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Title cannot be empty")
    @Size(min = 3, max = 100, message = "Title must be between 3 and 100 characters")
    private String title;

    @NotBlank(message = "Description cannot be empty")
    @Size(min = 10, max = 500, message = "Description must be between 10 and 500 characters")
    private String description;

    @NotNull(message = "Budget allocation cannot be null")
    private Double budgetallocation;

    @NotBlank(message = "Target platform cannot be empty")
    private String targetplatform;

    @NotBlank(message = "Status cannot be empty")
    private String status;

    public marketingcampaign() {
    }

    public marketingcampaign(String title, String description, Double budgetallocation, String targetplatform, String status) {
        this.title = title;
        this.description = description;
        this.budgetallocation = budgetallocation;
        this.targetplatform = targetplatform;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getBudgetallocation() {
        return budgetallocation;
    }

    public void setBudgetallocation(Double budgetallocation) {
        this.budgetallocation = budgetallocation;
    }

    public String getTargetplatform() {
        return targetplatform;
    }

    public void setTargetplatform(String targetplatform) {
        this.targetplatform = targetplatform;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}