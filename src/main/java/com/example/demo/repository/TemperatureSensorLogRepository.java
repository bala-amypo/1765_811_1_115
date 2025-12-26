package com.example.demo.repository;

import com.example.demo.entity.TemperatureSensorLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface TemperatureSensorLogRepository extends JpaRepository<TemperatureSensorLog, Long> {
    List<TemperatureSensorLog> findByShipmentIdAndTimestampBetween(Long shipmentId, LocalDate start, LocalDate end);
}
