@Service
public class BreachDetectionServiceImpl implements BreachDetectionService {

    private final BreachRecordRepository repository;

    public BreachDetectionServiceImpl(BreachRecordRepository repository) {
        this.repository = repository;
    }

    public BreachRecordEntity logBreach(BreachRecordEntity breach) {
        return repository.save(breach);
    }

    public List<BreachRecordEntity> getBreachesByShipment(Long shipmentId) {
        return repository.findByShipmentId(shipmentId);
    }

    public BreachRecordEntity resolveBreach(Long id) {
        BreachRecordEntity b = repository.findById(id).orElseThrow();
        b.setResolved(true);
        return repository.save(b);
    }

    public BreachRecordEntity getBreachById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<BreachRecordEntity> getAllBreaches() {
        return repository.findAll();
    }
}
