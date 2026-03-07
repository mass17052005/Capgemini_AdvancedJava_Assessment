package com.example.demo.dto;

import jakarta.validation.constraints.*;

public class CustomerRequestDTO {

    @NotBlank
    private String name;

    @Email
    private String email;

    private String phoneNumber;
    private String address;

    public CustomerRequestDTO(){}

    public String getName(){ return name; }
    public void setName(String name){ this.name=name; }

    public String getEmail(){ return email; }
    public void setEmail(String email){ this.email=email; }

    public String getPhoneNumber(){ return phoneNumber; }
    public void setPhoneNumber(String phoneNumber){ this.phoneNumber=phoneNumber; }

    public String getAddress(){ return address; }
    public void setAddress(String address){ this.address=address; }
}