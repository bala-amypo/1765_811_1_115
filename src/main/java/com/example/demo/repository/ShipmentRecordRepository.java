import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface ShipmentRecordRepository
        extends JpaRepository<ShipmentRecordEntity, Long> {
    ShipmentRecordEntity findByShipmentCode(String code);
}
BreachRecordRepository