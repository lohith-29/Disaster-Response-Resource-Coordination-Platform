package com.example.disaster.controller;

import com.example.disaster.service.RequestService;
import com.example.disaster.service.VolunteerService;
import com.example.disaster.service.NotificationService;
import com.example.disaster.model.EmergencyRequest;
import com.example.disaster.model.Volunteer;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final RequestService requestService;
    private final VolunteerService volunteerService;
    private final NotificationService notificationService;

    public AdminController(RequestService requestService,
                           VolunteerService volunteerService,
                           NotificationService notificationService) {

        this.requestService = requestService;
        this.volunteerService = volunteerService;
        this.notificationService = notificationService;
    }

    // 📊 Dashboard Stats
    @GetMapping("/stats")
    public String getStats() {

        return "System Active | Requests: "
                + requestService.getAll().size()
                + " | Volunteers: "
                + volunteerService.getAll().size();
    }

    // 🚨 All emergency requests (DB view)
    @GetMapping("/requests")
    public List<EmergencyRequest> getAllRequests() {
        return requestService.getAll();
    }

    // 🧑‍🚒 All volunteers
    @GetMapping("/volunteers")
    public List<Volunteer> getAllVolunteers() {
        return volunteerService.getAll();
    }

    // 🔔 Send manual alert
    @PostMapping("/notify")
    public String notify(@RequestParam String message) {

        notificationService.sendNotification(message);

        return "Notification sent successfully!";
    }

    // 📡 View all notifications
    @GetMapping("/notifications")
    public List<String> getNotifications() {
        return notificationService.getAllNotifications();
    }

    // 🧹 Clear notifications
    @DeleteMapping("/notifications")
    public String clearNotifications() {

        notificationService.clearNotifications();

        return "Notifications cleared";
    }
}