public interface TemperatureSensorLogRepository
        extends JpaRepository<TemperatureSensorLogEntity, Long> {
    List<TemperatureSensorLogEntity> findByShipmentId(Long shipmentId);
}
