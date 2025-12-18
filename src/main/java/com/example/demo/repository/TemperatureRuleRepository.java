package com.example.demo.repository;

import com.example.demo.entity.TemperatureRuleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TemperatureRuleRepository
        extends JpaRepository<TemperatureRuleEntity, Long> {

    @Query("""
           SELECT r FROM TemperatureRuleEntity r
           WHERE r.productType = :productType
           AND r.effectiveFrom <= :date
           AND r.effectiveTo >= :date
           """)
    List<TemperatureRuleEntity> findActiveRules(
            @Param("productType") String productType,
            @Param("date") LocalDate date
    );
}
