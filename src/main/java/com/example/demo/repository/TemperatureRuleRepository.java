// package com.example.demo.repository;

// import java.util.List;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;
// import com.example.demo.entity.TemperatureRule;

// @Repository
// public interface TemperatureRuleRepository
//         extends JpaRepository<TemperatureRule, Long> {

//     List<TemperatureRule> findByActiveTrue();

//     List<TemperatureRule> findByProductType(String productType);
// }
package com.example.demo.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.TemperatureRule;

public interface TemperatureRuleRepository extends JpaRepository<TemperatureRule, Long> {

    List<TemperatureRule> findByActiveTrue();

    List<TemperatureRule> findByProductType(String productType);

    @Query("""
        SELECT t FROM TemperatureRule t
        WHERE t.productType = :productType
        AND t.active = true
    """)
    TemperatureRule findApplicableRule(
        @Param("productType") String productType,
        @Param("date") LocalDate date
    );
}
