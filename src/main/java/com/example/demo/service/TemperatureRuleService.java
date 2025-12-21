// package com.example.demo.service;

// import java.util.List;
// import com.example.demo.entity.TemperatureRule;

// public interface TemperatureRuleService {

//     TemperatureRule saveRule(TemperatureRule rule);

//     List<TemperatureRule> getActiveRules();

//     List<TemperatureRule> getRulesByProductType(String productType);
// }

package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.TemperatureRule;

public interface TemperatureRuleService {

    TemperatureRule saveRule(TemperatureRule rule);

    List<TemperatureRule> getActiveRules();

    List<TemperatureRule> getRulesByProductType(String productType);

    TemperatureRule getRuleForProduct(String productType);

    List<TemperatureRule> getAllRules();
}
