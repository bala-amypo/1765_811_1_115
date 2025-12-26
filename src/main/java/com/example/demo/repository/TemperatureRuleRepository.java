package com.example.demo.repository;

import com.example.demo.entity.TemperatureRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface TemperatureRuleRepository extends JpaRepository<TemperatureRule, Long> {

    // For finding a rule by product and date (custom query can be added if needed)
    Optional<TemperatureRule> findApplicableRule(String productId, LocalDate date);

    // Find all active rules
    List<TemperatureRule> findByActiveTrue();

    // Optional: find rules by product
    List<TemperatureRule> findByProductId(Long productId);
}
