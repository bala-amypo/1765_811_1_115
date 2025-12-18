@RestController
@RequestMapping("/api/breaches")
@Tag(name = "Breaches")
public class BreachRecordController {

    private final BreachDetectionService service;

    public BreachRecordController(BreachDetectionService service) {
        this.service = service;
    }

    @PostMapping
    public BreachRecordEntity log(@RequestBody BreachRecordEntity b) {
        return service.logBreach(b);
    }

    @PutMapping("/{id}/resolve")
    public BreachRecordEntity resolve(@PathVariable Long id) {
        return service.resolveBreach(id);
    }

    @GetMapping
    public List<BreachRecordEntity> all() {
        return service.getAllBreaches();
    }
}
