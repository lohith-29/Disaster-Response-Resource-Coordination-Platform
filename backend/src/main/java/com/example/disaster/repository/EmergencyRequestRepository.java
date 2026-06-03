package com.example.disaster.repository;

import com.example.disaster.model.EmergencyRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmergencyRequestRepository extends JpaRepository<EmergencyRequest, Long> {

    List<EmergencyRequest> findByStatus(String status);

    List<EmergencyRequest> findByPriority(String priority);
}