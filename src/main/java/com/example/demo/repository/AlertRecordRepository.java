package com.example.demo.repository;

import com.example.demo.entity.AlertRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AlertRecordRepository extends JpaRepository<AlertRecordEntity, Long> {
    List<AlertRecordEntity> findByShipmentId(Long shipmentId);
}
