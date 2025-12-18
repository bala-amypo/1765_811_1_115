@Service
public class TemperatureLogServiceImpl implements TemperatureLogService {

    private final TemperatureSensorLogRepository repository;

    public TemperatureLogServiceImpl(TemperatureSensorLogRepository repository) {
        this.repository = repository;
    }

    public TemperatureSensorLogEntity recordLog(TemperatureSensorLogEntity log) {
        return repository.save(log);
    }

    public List<TemperatureSensorLogEntity> getLogsByShipment(Long shipmentId) {
        return repository.findByShipmentId(shipmentId);
    }

    public TemperatureSensorLogEntity getLogById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<TemperatureSensorLogEntity> getAllLogs() {
        return repository.findAll();
    }
}
