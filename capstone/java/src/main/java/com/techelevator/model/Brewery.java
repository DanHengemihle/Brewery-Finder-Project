package com.techelevator.model;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class Brewery {
    private int id;
    private int brewerId;
    @NotBlank
    private String name;
    private String breweryType;
    private String street;
    private String address2;
    private String address3;
    private String city;
    private String state;
    private String countyProvince;
    private String country;
    private String Longitude;
    private String latitude;
    private String phone;
    private String websiteUrl;
    private String hoursOfOperation;


    public int getBrewerId() {
        return brewerId;
    }

    public void setBrewerId(int brewerId) {
        this.brewerId = brewerId;
    }

    public void setId(int id) {
        this.id = id;
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

//    public void setPostalCode(String postalCode) {
//        this.postalCode = postalCode;
//    }
//
//    public void setCountry(String country) {
//        this.country = country;
//    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

//    public void setBeerList(List<String> beerList) {
//        this.beerList = beerList;
//    }

    public void setHoursOfOperation(String hoursOfOperation) {
        this.hoursOfOperation = hoursOfOperation;
    }


//    public String getRole() {
//        return role;
//    }

    public int getId() {
        return id;
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

//    public String getPostalCode() {
//        return postalCode;
//    }
//
//    public String getCountry() {
//        return country;
//    }

    public String getPhone() {
        return phone;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }
//
//    public List<String> getBeerList() {
//        return beerList;
//    }

    public String getHoursOfOperation() {
        return hoursOfOperation;
    }

}
