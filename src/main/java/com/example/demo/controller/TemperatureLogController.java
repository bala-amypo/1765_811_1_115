@RestController
@RequestMapping("/api/logs")
@Tag(name = "Temperature Logs")
public class TemperatureLogController {

    private final TemperatureLogService service;

    public TemperatureLogController(TemperatureLogService service) {
        this.service = service;
    }

    @PostMapping
    public TemperatureSensorLogEntity create(@RequestBody TemperatureSensorLogEntity log) {
        return service.recordLog(log);
    }

    @GetMapping("/shipment/{shipmentId}")
    public List<TemperatureSensorLogEntity> byShipment(@PathVariable Long shipmentId) {
        return service.getLogsByShipment(shipmentId);
    }

    @GetMapping
    public List<TemperatureSensorLogEntity> all() {
        return service.getAllLogs();
    }
}
