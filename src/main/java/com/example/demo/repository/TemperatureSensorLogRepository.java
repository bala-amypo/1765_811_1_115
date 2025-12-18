import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface TemperatureSensorLogRepository
        extends JpaRepository<TemperatureSensorLogEntity, Long> {
    List<TemperatureSensorLogEntity> findByShipmentId(Long shipmentId);
}
