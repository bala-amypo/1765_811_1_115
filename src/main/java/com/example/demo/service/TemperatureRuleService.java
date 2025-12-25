import java.util.List;
import java.util.Optional;  // <- import Optional

public interface TemperatureRuleService {
    TemperatureRule createRule(TemperatureRule rule);
    List<TemperatureRule> getActiveRules();
    Optional<TemperatureRule> getRuleForProduct(String productType); // <- change return type
    List<TemperatureRule> getAllRules();
}
