package com.example.disaster.dto;

public class VolunteerDTO {

    private String name;
    private String skills;
    private String status;
    private double latitude;
    private double longitude;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSkills() { return skills; }
    public void setSkills(String skills) { this.skills = skills; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }

    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }
}