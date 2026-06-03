package com.example.disaster.controller;

import com.example.disaster.model.Volunteer;
import com.example.disaster.service.VolunteerService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/volunteers")
public class VolunteerController {

    private final VolunteerService service;

    public VolunteerController(VolunteerService service) {
        this.service = service;
    }

    @PostMapping
    public Volunteer add(@RequestBody Volunteer v) {
        return service.addVolunteer(v);
    }

    @GetMapping
    public List<Volunteer> getAll() {
        return service.getAll();
    }

    @GetMapping("/available")
    public List<Volunteer> available() {
        return service.getAvailable();
    }
}