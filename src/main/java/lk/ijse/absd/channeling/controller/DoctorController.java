package lk.ijse.absd.channeling.controller;

import lk.ijse.absd.channeling.dto.DoctorDTO;
import lk.ijse.absd.channeling.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctors/")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllDoctors() {
        return ResponseEntity.ok(doctorService.getAll());
    }

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveDoctors(@RequestBody DoctorDTO doctorDTO) {
        return ResponseEntity.ok(doctorService.add(doctorDTO));
    }

    @PutMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateDoctors(@RequestBody DoctorDTO doctorDTO) {
        return ResponseEntity.ok(doctorService.update(doctorDTO));
    }

    @GetMapping(value = "/{doctorId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchDoctors(@PathVariable("doctorId") Integer doctorId) {
        return ResponseEntity.ok(doctorService.search(doctorId));
    }

    @DeleteMapping(value = "/{doctorId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteDoctors(@PathVariable("doctorId") Integer doctorId) {
        return ResponseEntity.ok(doctorService.delete(doctorId));
    }

}
