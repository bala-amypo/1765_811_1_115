package com.example.demo.repository;

import com.example.demo.entity.TemperatureRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface TemperatureRuleRepository
        extends JpaRepository<TemperatureRule, Long> {

    // REQUIRED BY TEST
    Optional<TemperatureRule> findByProductTypeAndActiveTrue(String productType);

    // REQUIRED BY TEST
    default Optional<TemperatureRule> findApplicableRule(String productType, LocalDate date) {
        return findByProductTypeAndActiveTrue(productType);
    }
}
