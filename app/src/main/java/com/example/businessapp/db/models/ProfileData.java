package com.example.businessapp.db.models;

import java.util.ArrayList;

public class ProfileData {
    private String userName;
    private String shopName;
    private String contact_number;
    private String area_name;

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    private String img_url;

    public ProfileData(String userName, String shopName, String contact_number, String area_name,ArrayList<String> workingDays, boolean onSite_service, String filepath,String img_url) {
        this.userName = userName;
        this.shopName = shopName;
        this.contact_number = contact_number;
        this.area_name = area_name;
       this.workingDays = workingDays;
        this.onSite_service = onSite_service;
        this.filepath = filepath;
        this.img_url=img_url;
    }

    ArrayList<String> workingDays;
    private boolean onSite_service;
    private String filepath;
    public ProfileData(){}

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    public String getArea_name() {
        return area_name;
    }

    public void setArea_name(String area_name) {
        this.area_name = area_name;
    }

    public ArrayList<String> getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(ArrayList<String> workingDays) {
        this.workingDays = workingDays;
    }

    public boolean isOnSite_service() {
        return onSite_service;
    }

    public void setOnSite_service(boolean onSite_service) {
        this.onSite_service = onSite_service;
    }



    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }


}
