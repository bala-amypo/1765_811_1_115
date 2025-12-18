import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class AlertServiceImpl implements AlertService {

    private final AlertRecordRepository repository;

    public AlertServiceImpl(AlertRecordRepository repository) {
        this.repository = repository;
    }

    public AlertRecordEntity triggerAlert(AlertRecordEntity alert) {
        return repository.save(alert);
    }

    public AlertRecordEntity acknowledgeAlert(Long id) {
        AlertRecordEntity a = repository.findById(id).orElseThrow();
        a.setAcknowledged(true);
        return repository.save(a);
    }

    public List<AlertRecordEntity> getAlertsByShipment(Long shipmentId) {
        return repository.findByShipmentId(shipmentId);
    }

    public List<AlertRecordEntity> getAllAlerts() {
        return repository.findAll();
    }
}
