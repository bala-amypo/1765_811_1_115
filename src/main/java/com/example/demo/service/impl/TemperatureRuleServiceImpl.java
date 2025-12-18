// package com.example.demo.service.impl;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.example.demo.entity.TemperatureRuleEntity;
// import com.example.demo.repository.TemperatureRuleRepository;
// import com.example.demo.service.TemperatureRuleService;

// @Service
// public class TemperatureRuleServiceImpl implements TemperatureRuleService {

//     @Autowired
//     private TemperatureRuleRepository repository;

//     @Override
//     public TemperatureRuleEntity saveRule(TemperatureRuleEntity rule) {
//         return repository.save(rule);
//     }

//     @Override
//     public List<TemperatureRuleEntity> getActiveRules() {
//         return repository.findByActiveTrue();
//     }

//     @Override
//     public List<TemperatureRuleEntity> getRulesByProductType(String productType) {
//         return repository.findByProductType(productType);
//     }
// }
