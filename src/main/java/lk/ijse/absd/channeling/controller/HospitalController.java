package lk.ijse.absd.channeling.controller;

import lk.ijse.absd.channeling.dto.HospitalDTO;
import lk.ijse.absd.channeling.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/hospitals/")
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllHospitals(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(hospitalService.getAll());
    }

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveHospitals(@RequestBody HospitalDTO hospitalDTO) {
        return ResponseEntity.ok(hospitalService.add(hospitalDTO));
    }

    @PutMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateHospitals(@RequestBody HospitalDTO hospitalDTO) {
        return ResponseEntity.ok(hospitalService.update(hospitalDTO));
    }

    @GetMapping(value = "/{hospitalId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchHospitals(@PathVariable("hospitalId") Integer hospitalId) {
        return ResponseEntity.ok(hospitalService.search(hospitalId));
    }

    @DeleteMapping(value = "/{hospitalId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteHospitals(@PathVariable("hospitalId") Integer hospitalId) {
        return ResponseEntity.ok(hospitalService.delete(hospitalId));
    }

}
