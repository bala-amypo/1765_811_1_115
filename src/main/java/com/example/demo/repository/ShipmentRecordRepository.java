
package com.example.demo.repository;

import com.example.demo.entity.AlertRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ShipmentRecordRepository extends JpaRepository<ShipmentRecordRepository, Long> {
    List<ShipmentRecordRepository> findByShipmentId(Long shipmentId);
}
