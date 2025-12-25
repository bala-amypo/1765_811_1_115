package com.example.demo.repository;

import com.example.demo.entity.TemperatureRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface TemperatureRuleRepository
        extends JpaRepository<TemperatureRule, Long> {

    // REQUIRED
    List<TemperatureRule> findByActiveTrue();

    // REQUIRED BY TEST CASES
    default Optional<TemperatureRule> findApplicableRule(
            String productType, LocalDate date) {

        return findByActiveTrue().stream()
                .filter(r -> r.getProductType().equals(productType))
                .filter(r -> !date.isBefore(r.getEffectiveFrom())
                          && !date.isAfter(r.getEffectiveTo()))
                .findFirst();
    }
}
