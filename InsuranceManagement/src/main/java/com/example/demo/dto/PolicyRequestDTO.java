package com.example.demo.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.*;
public class PolicyRequestDTO {

    @NotBlank
    private String policyNumber;

    private String policyType;

    @Positive
    private double premiumAmount;

    @Positive
    private double coverageAmount;

    @NotNull
    private LocalDate startDate;

    private LocalDate endDate;

    private Long customerId;

    public PolicyRequestDTO(){}

    public String getPolicyNumber(){ return policyNumber; }
    public void setPolicyNumber(String policyNumber){ this.policyNumber=policyNumber; }

    public String getPolicyType(){ return policyType; }
    public void setPolicyType(String policyType){ this.policyType=policyType; }

    public double getPremiumAmount(){ return premiumAmount; }
    public void setPremiumAmount(double premiumAmount){ this.premiumAmount=premiumAmount; }

    public double getCoverageAmount(){ return coverageAmount; }
    public void setCoverageAmount(double coverageAmount){ this.coverageAmount=coverageAmount; }

    public LocalDate getStartDate(){ return startDate; }
    public void setStartDate(LocalDate startDate){ this.startDate=startDate; }

    public LocalDate getEndDate(){ return endDate; }
    public void setEndDate(LocalDate endDate){ this.endDate=endDate; }

    public Long getCustomerId(){ return customerId; }
    public void setCustomerId(Long customerId){ this.customerId=customerId; }
}