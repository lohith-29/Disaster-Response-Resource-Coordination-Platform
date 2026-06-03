package com.example.disaster.service;

import com.example.disaster.model.Volunteer;
import com.example.disaster.repository.VolunteerRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolunteerService {

    private final VolunteerRepository repository;

    public VolunteerService(VolunteerRepository repository) {
        this.repository = repository;
    }

    public Volunteer addVolunteer(Volunteer v) {
        return repository.save(v);
    }

    public List<Volunteer> getAvailable() {
        return repository.findByStatus("AVAILABLE");
    }

    public List<Volunteer> getAll() {
        return repository.findAll();
    }
}