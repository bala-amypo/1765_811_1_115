import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface TemperatureRuleRepository
        extends JpaRepository<TemperatureRuleEntity, Long> {

    @Query("SELECT r FROM TemperatureRuleEntity r WHERE r.productType = :productType AND r.active = true AND :date BETWEEN r.effectiveFrom AND r.effectiveTo")
    TemperatureRuleEntity findApplicableRule(String productType, LocalDate date);
}
package com.example.demo.repository;

import com.example.demo.entity.AlertRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AlertRecordRepository extends JpaRepository<AlertRecordEntity, Long> {
    List<AlertRecordEntity> findByShipmentId(Long shipmentId);
}
