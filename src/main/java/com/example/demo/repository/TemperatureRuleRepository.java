package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.TemperatureRule;

public interface TemperatureRuleRepository
        extends JpaRepository<TemperatureRule, Long> {

    List<TemperatureRule> findByActiveTrue();

    @Query("""
        SELECT t FROM TemperatureRule t
        WHERE t.productType = :productType
          AND t.active = true
          AND :date BETWEEN t.effectiveFrom AND t.effectiveTo
    """)
    TemperatureRule findApplicableRule(
            @Param("productType") String productType,
            @Param("date") LocalDate date
    );
}
