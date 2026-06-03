package com.example.disaster.dto;

public class RequestDTO {

    private String disasterType;
    private String description;
    private String priority;
    private double latitude;
    private double longitude;
    private Long userId;

    public String getDisasterType() { return disasterType; }
    public void setDisasterType(String disasterType) { this.disasterType = disasterType; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }

    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }

    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
}