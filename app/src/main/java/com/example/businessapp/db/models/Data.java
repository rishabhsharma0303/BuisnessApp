package com.example.businessapp.db.models;

public class Data {
    private String id;
    private String lattitude;
    private String longitude;
    public Data(ProfileData profileData)
    {

    }

    public  Data(String id, String lattitude, String longitude)
    {
        this.id = id;
        this.lattitude = lattitude;

        this.longitude = longitude;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLattitude() {
        return lattitude;
    }

    public void setLattitude(String lattitude) {
        this.lattitude = lattitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
