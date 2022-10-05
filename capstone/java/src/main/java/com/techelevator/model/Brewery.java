package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class Brewery {
    private int id;
    private int brewerId;
    @NotBlank
    private String name;
    private String street;
    private String city;
    private String state;
    private String phone;
    private String websiteUrl;
    private String hoursOfOperation;

    public Brewery() {}

    public Brewery(int id, int brewerId, String name, String street, String city, String state, String phone, String websiteUrl) {
        this.id = id;
        this.brewerId = brewerId;
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.phone = phone;
        this.websiteUrl = websiteUrl;
    }

    public int getBrewerId() {
        return brewerId;
    }

    public void setBrewerId(int brewerId) {
        this.brewerId = brewerId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public void setHoursOfOperation(String hoursOfOperation) {
        this.hoursOfOperation = hoursOfOperation;
    }

    public String getName() {
        return name;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public String getHoursOfOperation() {
        return hoursOfOperation;
    }

}
