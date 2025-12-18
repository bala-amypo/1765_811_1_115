// package com.example.demo.controller;

// import com.example.demo.entity.TemperatureRuleEntity;
// import com.example.demo.service.TemperatureRuleService;
// import io.swagger.v3.oas.annotations.tags.Tag;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/api/rules")
// @Tag(name = "Temperature Rules")
// public class TemperatureRuleController {

//     private final TemperatureRuleService service;

//     public TemperatureRuleController(TemperatureRuleService service) {
//         this.service = service;
//     }

//     @PostMapping
//     public TemperatureRuleEntity create(@RequestBody TemperatureRuleEntity rule) {
//         return service.createRule(rule);
//     }

//     @PutMapping("/{id}")
//     public TemperatureRuleEntity update(@PathVariable Long id, @RequestBody TemperatureRuleEntity rule) {
//         return service.updateRule(id, rule);
//     }

//     @GetMapping
//     public List<TemperatureRuleEntity> getAll() {
//         return service.getAllRules();
//     }
// }
