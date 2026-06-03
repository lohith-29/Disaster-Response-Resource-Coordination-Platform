package com.example.disaster.controller;

import com.example.disaster.model.EmergencyRequest;
import com.example.disaster.service.RequestService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/requests")
public class RequestController {

    private final RequestService service;

    public RequestController(RequestService service) {
        this.service = service;
    }

    @PostMapping
    public EmergencyRequest create(
            @RequestBody EmergencyRequest req
    ) {
        return service.createRequest(req);
    }

    @GetMapping
    public List<EmergencyRequest> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public EmergencyRequest updateStatus(
            @PathVariable Long id,
            @RequestParam String status
    ) {
        return service.updateStatus(id, status);
    }
}