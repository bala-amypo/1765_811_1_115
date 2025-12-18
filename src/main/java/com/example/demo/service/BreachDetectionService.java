public interface BreachDetectionService {

    BreachRecordEntity createBreach(BreachRecordEntity breach);

    List<BreachRecordEntity> getAllBreaches();

    BreachRecordEntity getBreachById(Long id);

    void resolveBreach(Long id);   // ✅ ADD THIS
}
