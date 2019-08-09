package lk.ijse.absd.channeling.controller;

import lk.ijse.absd.channeling.dto.MedicineDTO;
import lk.ijse.absd.channeling.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/medicine/")
public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllMedicines() {
        return ResponseEntity.ok(medicineService.getAll());
    }

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveMedicines(@RequestBody MedicineDTO medicineDTO) {
        return ResponseEntity.ok(medicineService.add(medicineDTO));
    }

    @PutMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateMedicines(@RequestBody MedicineDTO medicineDTO) {
        return ResponseEntity.ok(medicineService.update(medicineDTO));
    }

    @GetMapping(value = "/{medicineId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchMedicines(@PathVariable("medicineId") Integer medicineId) {
        return ResponseEntity.ok(medicineService.search(medicineId));
    }

    @DeleteMapping(value = "/{medicineId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteMedicines(@PathVariable("medicineId") Integer medicineId) {
        return ResponseEntity.ok(medicineService.delete(medicineId));
    }

}
