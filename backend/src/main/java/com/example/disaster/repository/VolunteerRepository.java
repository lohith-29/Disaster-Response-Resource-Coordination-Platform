package com.example.disaster.repository;

import com.example.disaster.model.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VolunteerRepository extends JpaRepository<Volunteer, Long> {

    List<Volunteer> findByStatus(String status);
}
