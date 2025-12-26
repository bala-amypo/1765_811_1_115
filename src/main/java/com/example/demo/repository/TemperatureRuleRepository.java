package com.example.demo.repository;

import com.example.demo.entity.TemperatureRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TemperatureRuleRepository extends JpaRepository<TemperatureRule, Long> {
    List<TemperatureRule> findByProductId(Long productId);
}
