public interface TemperatureRuleRepository
        extends JpaRepository<TemperatureRuleEntity, Long> {

    @Query("SELECT r FROM TemperatureRuleEntity r WHERE r.productType = :productType AND r.active = true AND :date BETWEEN r.effectiveFrom AND r.effectiveTo")
    TemperatureRuleEntity findApplicableRule(String productType, LocalDate date);
}
