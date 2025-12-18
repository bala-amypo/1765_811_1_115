public interface BreachRecordRepository
        extends JpaRepository<BreachRecordEntity, Long> {
    List<BreachRecordEntity> findByShipmentId(Long shipmentId);
}
