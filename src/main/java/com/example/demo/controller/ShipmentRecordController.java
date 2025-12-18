@RestController
@RequestMapping("/api/shipments")
@Tag(name = "Shipments")
public class ShipmentRecordController {

    private final ShipmentRecordService service;

    public ShipmentRecordController(ShipmentRecordService service) {
        this.service = service;
    }

    @PostMapping
    public ShipmentRecordEntity create(@RequestBody ShipmentRecordEntity s) {
        return service.createShipment(s);
    }

    @PutMapping("/{id}/status")
    public ShipmentRecordEntity update(@PathVariable Long id, @RequestParam String status) {
        return service.updateShipmentStatus(id, status);
    }

    @GetMapping("/{id}")
    public ShipmentRecordEntity get(@PathVariable Long id) {
        return service.getShipmentById(id);
    }

    @GetMapping("/code/{code}")
    public ShipmentRecordEntity getByCode(@PathVariable String code) {
        return service.getShipmentByCode(code);
    }

    @GetMapping
    public List<ShipmentRecordEntity> all() {
        return service.getAllShipments();
    }
}
