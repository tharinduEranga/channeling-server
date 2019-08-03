package lk.ijse.absd.channeling.controller;

import lk.ijse.absd.channeling.dto.PatientDTO;
import lk.ijse.absd.channeling.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients/")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllHospitals() {
        return ResponseEntity.ok(patientService.getAll());
    }

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveHospitals(@RequestBody PatientDTO patientDTO) {
        return ResponseEntity.ok(patientService.add(patientDTO));
    }

    @PutMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateHospitals(@RequestBody PatientDTO patientDTO) {
        return ResponseEntity.ok(patientService.update(patientDTO));
    }

    @GetMapping(value = "/{patientId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchHospitals(@PathVariable("patientId") Integer patientId) {
        return ResponseEntity.ok(patientService.search(patientId));
    }

    @DeleteMapping(value = "/{patientId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteHospitals(@PathVariable("patientId") Integer patientId) {
        return ResponseEntity.ok(patientService.delete(patientId));
    }
}
