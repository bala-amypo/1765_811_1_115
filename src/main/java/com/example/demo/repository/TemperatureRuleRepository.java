
package com.example.demo.repository;

import com.example.demo.entity.AlertRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TemperatureRuleRepository extends JpaRepository<TemperatureRuleRepository, Long> {
    List<TemperatureRuleRepository> findByShipmentId(Long shipmentId);
}
