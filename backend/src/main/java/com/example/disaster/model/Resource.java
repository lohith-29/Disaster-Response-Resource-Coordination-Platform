package com.example.disaster.model;

import jakarta.persistence.*;

@Entity
@Table(name = "resources")
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String resourceName;

    private int quantity;

    private String location;

    // Getters & Setters

    public Long getId() { return id; }

    public String getResourceName() { return resourceName; }
    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getLocation() { return location; }
    public void setLocation(String location) {
        this.location = location;
    }
}