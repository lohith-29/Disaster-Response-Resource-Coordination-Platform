package com.example.disaster.service;

import com.example.disaster.model.EmergencyRequest;
import com.example.disaster.repository.EmergencyRequestRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestService {

    private final EmergencyRequestRepository repository;

    public RequestService(EmergencyRequestRepository repository) {
        this.repository = repository;
    }

    public EmergencyRequest createRequest(EmergencyRequest request) {
        return repository.save(request);
    }

    public List<EmergencyRequest> getAll() {
        return repository.findAll();
    }

    public List<EmergencyRequest> getByStatus(String status) {
        return repository.findByStatus(status);
    }

    public EmergencyRequest updateStatus(Long id, String status) {

        EmergencyRequest req = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Request not found"));

        req.setStatus(status);

        return repository.save(req);
    }
}