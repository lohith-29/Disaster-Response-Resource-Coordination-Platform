package com.example.disaster.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "emergency_requests")
public class EmergencyRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String disasterType;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String priority; // LOW, MEDIUM, HIGH, CRITICAL

    private double latitude;
    private double longitude;

    private String status = "PENDING";

    private Long userId;

    private LocalDateTime createdAt = LocalDateTime.now();

    // Getters & Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

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

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public LocalDateTime getCreatedAt() { return createdAt; }
}