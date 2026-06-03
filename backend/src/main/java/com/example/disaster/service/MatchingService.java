package com.example.disaster.service;

import com.example.disaster.model.Volunteer;
import com.example.disaster.repository.VolunteerRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchingService {

    private final VolunteerRepository repository;

    public MatchingService(VolunteerRepository repository) {
        this.repository = repository;
    }

    // Simple nearest logic (upgrade later with Haversine)
    public List<Volunteer> findNearest(double lat, double lng) {

        List<Volunteer> volunteers =
                repository.findByStatus("AVAILABLE");

        volunteers.sort((a, b) -> {

            double d1 = distance(lat, lng,
                    a.getLatitude(), a.getLongitude());

            double d2 = distance(lat, lng,
                    b.getLatitude(), b.getLongitude());

            return Double.compare(d1, d2);
        });

        return volunteers;
    }

    private double distance(double lat1, double lon1,
                            double lat2, double lon2) {

        return Math.sqrt(
                Math.pow(lat1 - lat2, 2) +
                Math.pow(lon1 - lon2, 2)
        );
    }
}