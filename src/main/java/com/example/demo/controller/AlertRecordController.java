import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;

@RestController
@RequestMapping("/api/alerts")
@Tag(name = "Alerts")
public class AlertRecordController {

    private final AlertService service;

    public AlertRecordController(AlertService service) {
        this.service = service;
    }

    @PostMapping
    public AlertRecordEntity trigger(@RequestBody AlertRecordEntity a) {
        return service.triggerAlert(a);
    }

    @PutMapping("/{id}/acknowledge")
    public AlertRecordEntity ack(@PathVariable Long id) {
        return service.acknowledgeAlert(id);
    }

    @GetMapping
    public List<AlertRecordEntity> all() {
        return service.getAllAlerts();
    }
}
