public interface ShipmentRecordRepository
        extends JpaRepository<ShipmentRecordEntity, Long> {
    ShipmentRecordEntity findByShipmentCode(String code);
}
