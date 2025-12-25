@Repository
public interface TemperatureRuleRepository
        extends JpaRepository<TemperatureRule, Long> {

    List<TemperatureRule> findByActiveTrue();

    @Query("""
        SELECT r FROM TemperatureRule r
        WHERE r.productType = :productType
        AND :temperature BETWEEN r.minTemp AND r.maxTemp
        AND r.active = true
    """)
    TemperatureRule findApplicableRule(
        @Param("productType") String productType,
        @Param("temperature") Double temperature
    );
}
