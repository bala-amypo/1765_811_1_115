package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.AlertRecordEntity;

import java.util.List;

@Repository
public interface AlertRecordRepository extends JpaRepository<AlertRecordEntity, Long> {
    List<AlertRecordEntity> findByShipmentId(Long shipmentId);
}
