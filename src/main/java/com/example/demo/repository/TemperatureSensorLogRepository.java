package com.example.demo.repository;

import com.example.demo.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.*;
public interface TemperatureSensorLogRepository extends JpaRepository<TemperatureSensorLog, Long> {
    List<TemperatureSensorLog> findByShipmentId(Long shipmentId);
}
