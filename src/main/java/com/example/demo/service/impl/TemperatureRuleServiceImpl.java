import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.TemperatureRule;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.TemperatureRuleRepository;
import com.example.demo.service.TemperatureRuleService;

@Service
public class TemperatureRuleServiceImpl implements TemperatureRuleService {

    private final TemperatureRuleRepository repository;

    // ✅ REQUIRED constructor signature
    public TemperatureRuleServiceImpl(TemperatureRuleRepository repository) {
        this.repository = repository;
    }

    @Override
    public TemperatureRule createRule(TemperatureRule rule) {

        if (rule.getMinTemp() >= rule.getMaxTemp()) {
            throw new BadRequestException(
                "Minimum temperature must be less than maximum temperature"
            );
        }

        return repository.save(rule);
    }

    @Override
    public List<TemperatureRule> getActiveRules() {
        return repository.findByActiveTrue();
    }

    @Override
public TemperatureRule getRuleForProduct(String productType) {
    TemperatureRule rule = repository.findApplicableRule(productType, LocalDate.now());

    if (rule == null) {
        throw new ResourceNotFoundException(
                "No active temperature rule found for product type: " + productType);
    }

    return rule;
}


    @Override
    public List<TemperatureRule> getAllRules() {
        return repository.findAll();
    }
    
}
