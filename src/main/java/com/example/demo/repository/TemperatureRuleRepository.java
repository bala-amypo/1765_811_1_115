package com.example.demo.repository;

import com.example.demo.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.*;

@Repository
public interface TemperatureRuleRepository extends JpaRepository<TemperatureRule, Long> {

    @Query("SELECT r FROM TemperatureRule r WHERE r.shipmentType = :type")
    TemperatureRule findApplicableRule(
        @Param("type") String type,
        @Param("value") Object value
    );
    Optional<TemperatureRule> findByProductTypeAndEffectiveFromLessThanEqualAndEffectiveToGreaterThanEqual(
            String productType, LocalDate from, LocalDate to);
}
