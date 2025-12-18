
package com.example.demo.repository;

import com.example.demo.entity.AlertRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BreachRecordRepository extends JpaRepository<BreachRecordRepository, Long> {
    List<BreachRecordRepository> findByShipmentId(Long shipmentId);
}
