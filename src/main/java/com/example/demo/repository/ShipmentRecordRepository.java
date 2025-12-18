public interface ShipmentRecordRepository extends JpaRepository<ShipmentRecord, Long> {
    ShipmentRecord findByShipmentCode(String code);
}
