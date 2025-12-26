package com.example.demo.repository;

import com.example.demo.entity.TemperatureRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface TemperatureRuleRepository extends JpaRepository<TemperatureRule, Long> {

    List<TemperatureRule> findByActiveTrue();

    @Query("SELECT r FROM TemperatureRule r WHERE r.productType = :productType AND r.startDate <= :date AND r.endDate >= :date")
    Optional<TemperatureRule> findApplicableRule(@Param("productType") String productType, @Param("date") LocalDate date);
}
