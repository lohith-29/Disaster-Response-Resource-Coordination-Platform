package com.example.disaster.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationService {

    private final List<String> notifications = new ArrayList<>();

    // Send notification
    public void sendNotification(String message) {

        System.out.println("🔔 NOTIFICATION: " + message);

        notifications.add(message);
    }

    // Get all notifications (admin dashboard)
    public List<String> getAllNotifications() {
        return notifications;
    }

    // Clear notifications
    public void clearNotifications() {
        notifications.clear();
    }
}