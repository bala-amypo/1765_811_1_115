package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.TemperatureSensorLog;

@Repository
public interface TemperatureSensorLogRepository
        extends JpaRepository<TemperatureSensorLog, Long> {

    List<TemperatureSensorLog> findByShipmentId(Long shipmentId);
}
