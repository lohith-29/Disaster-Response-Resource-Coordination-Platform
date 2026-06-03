package com.example.disaster.controller;

import com.example.disaster.repository.UserRepository;
import com.example.disaster.repository.EmergencyRequestRepository;
import com.example.disaster.repository.VolunteerRepository;
import com.example.disaster.repository.ResourceRepository;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/db")
public class DatabaseController {

    private final UserRepository userRepository;
    private final EmergencyRequestRepository requestRepository;
    private final VolunteerRepository volunteerRepository;
    private final ResourceRepository resourceRepository;

    public DatabaseController(UserRepository userRepository,
                              EmergencyRequestRepository requestRepository,
                              VolunteerRepository volunteerRepository,
                              ResourceRepository resourceRepository) {

        this.userRepository = userRepository;
        this.requestRepository = requestRepository;
        this.volunteerRepository = volunteerRepository;
        this.resourceRepository = resourceRepository;
    }

    // 📊 Total users
    @GetMapping("/users/count")
    public long userCount() {
        return userRepository.count();
    }

    // 🚨 Total requests
    @GetMapping("/requests/count")
    public long requestCount() {
        return requestRepository.count();
    }

    // 🧑‍🚒 Total volunteers
    @GetMapping("/volunteers/count")
    public long volunteerCount() {
        return volunteerRepository.count();
    }

    // 📦 Total resources
    @GetMapping("/resources/count")
    public long resourceCount() {
        return resourceRepository.count();
    }
}