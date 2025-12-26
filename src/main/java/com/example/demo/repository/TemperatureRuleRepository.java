package com.example.demo.repository;

import com.example.demo.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.*;
public interface TemperatureRuleRepository extends JpaRepository<TemperatureRule, Long> {
    List<TemperatureRule> findByActiveTrue();
    Optional<TemperatureRule> findApplicableRule(String productType, LocalDate date);
}
