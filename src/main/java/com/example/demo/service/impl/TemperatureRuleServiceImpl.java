// package com.example.demo.service.impl;

// import com.example.demo.entity.TemperatureRuleEntity;
// import com.example.demo.repository.TemperatureRuleRepository;
// import com.example.demo.service.TemperatureRuleService;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// public class TemperatureRuleServiceImpl implements TemperatureRuleService {

//     private final TemperatureRuleRepository repository;

//     public TemperatureRuleServiceImpl(TemperatureRuleRepository repository) {
//         this.repository = repository;
//     }

//     public TemperatureRuleEntity createRule(TemperatureRuleEntity rule) {
//         if (rule.getMinTemp() >= rule.getMaxTemp()) {
//             throw new IllegalArgumentException("Min temperature must be less than max temperature");
//         }
//         return repository.save(rule);
//     }

//     public TemperatureRuleEntity updateRule(Long id, TemperatureRuleEntity rule) {
//         rule.setId(id);
//         return repository.save(rule);
//     }

//     public List<TemperatureRuleEntity> getActiveRules() {
//         return repository.findByActiveTrue();
//     }

//     public List<TemperatureRuleEntity> getRulesByProduct(String productType) {
//         return repository.findByProductType(productType);
//     }

//     public List<TemperatureRuleEntity> getAllRules() {
//         return repository.findAll();
//     }
// }
