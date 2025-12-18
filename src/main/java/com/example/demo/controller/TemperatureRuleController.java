@RestController
@RequestMapping("/api/rules")
@Tag(name = "Temperature Rules")
public class TemperatureRuleController {

    private final TemperatureRuleService service;

    public TemperatureRuleController(TemperatureRuleService service) {
        this.service = service;
    }

    @PostMapping
    public TemperatureRuleEntity create(@RequestBody TemperatureRuleEntity rule) {
        return service.createRule(rule);
    }

    @GetMapping("/active")
    public List<TemperatureRuleEntity> active() {
        return service.getActiveRules();
    }

    @GetMapping
    public List<TemperatureRuleEntity> all() {
        return service.getAllRules();
    }
}
