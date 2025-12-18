import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;

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
