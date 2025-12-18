import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface TemperatureSensorLogRepository
        extends JpaRepository<TemperatureSensorLogEntity, Long> {
    List<TemperatureSensorLogEntity> findByShipmentId(Long shipmentId);
}
package com.example.demo.repository;

import com.example.demo.entity.AlertRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AlertRecordRepository extends JpaRepository<AlertRecordEntity, Long> {
    List<AlertRecordEntity> findByShipmentId(Long shipmentId);
}
