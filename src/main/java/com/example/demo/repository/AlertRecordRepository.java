public interface AlertRecordRepository
        extends JpaRepository<AlertRecordEntity, Long> {
    List<AlertRecordEntity> findByShipmentId(Long shipmentId);
}
