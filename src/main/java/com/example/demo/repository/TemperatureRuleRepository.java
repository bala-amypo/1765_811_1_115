package com.example.demo.repository;

import com.example.demo.entity.TemperatureRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface TemperatureRuleRepository extends JpaRepository<TemperatureRule, Long> {

    // Returns all active rules
    List<TemperatureRule> findByActiveTrue();

    // Returns the rule for a given product type that is effective on a certain date
    Optional<TemperatureRule> findByProductTypeAndStartDateBeforeAndEndDateAfter(
            String productType,
            LocalDate date1,
            LocalDate date2
    );

    // Optional: If your service needs a simpler “current rule” method
    default Optional<TemperatureRule> findApplicableRule(String productType, LocalDate date) {
        return findByProductTypeAndStartDateBeforeAndEndDateAfter(productType, date, date);
    }
}
