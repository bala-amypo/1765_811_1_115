package com.example.demo.repository;

import com.example.demo.entity.TemperatureRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TemperatureRuleRepository extends JpaRepository<TemperatureRule, Long> {

    List<TemperatureRule> findByProductTypeAndEffectiveFromLessThanEqualAndEffectiveToGreaterThanEqual(
            String productType,
            LocalDate startDate,
            LocalDate endDate
    );

    @Query("SELECT t FROM TemperatureRule t WHERE t.active = true")
    List<TemperatureRule> findByActiveTrue();
}
