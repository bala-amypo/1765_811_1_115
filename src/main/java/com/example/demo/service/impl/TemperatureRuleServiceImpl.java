import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class TemperatureRuleServiceImpl implements TemperatureRuleService {

    private final TemperatureRuleRepository repository;

    public TemperatureRuleServiceImpl(TemperatureRuleRepository repository) {
        this.repository = repository;
    }

    public TemperatureRuleEntity createRule(TemperatureRuleEntity rule) {
        if (rule.getMinTemp() >= rule.getMaxTemp()) {
            throw new IllegalArgumentException("Invalid temperature range");
        }
        return repository.save(rule);
    }

    public TemperatureRuleEntity updateRule(Long id, TemperatureRuleEntity rule) {
        TemperatureRuleEntity r = repository.findById(id).orElseThrow();
        r.setMinTemp(rule.getMinTemp());
        r.setMaxTemp(rule.getMaxTemp());
        r.setActive(rule.getActive());
        return repository.save(r);
    }

    public List<TemperatureRuleEntity> getActiveRules() {
        return repository.findAll().stream()
                .filter(TemperatureRuleEntity::getActive)
                .toList();
    }

    public TemperatureRuleEntity getRuleForProduct(String productType) {
        return repository.findApplicableRule(productType, java.time.LocalDate.now());
    }

    public List<TemperatureRuleEntity> getAllRules() {
        return repository.findAll();
    }
}
