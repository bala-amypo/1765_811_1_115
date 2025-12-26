package com.example.demo.repository;

import com.example.demo.entity.TemperatureRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface TemperatureRuleRepository extends JpaRepository<TemperatureRule, Long> {
    List<TemperatureRule> findByActiveTrue();

    // Custom query for applicable rule
    Optional<TemperatureRule> findByProductTypeAndEffectiveDateLessThanEqual(String productType, LocalDate date);
}
