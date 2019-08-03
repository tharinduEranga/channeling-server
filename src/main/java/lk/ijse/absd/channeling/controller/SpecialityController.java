package lk.ijse.absd.channeling.controller;

import lk.ijse.absd.channeling.dto.SpecialityDTO;
import lk.ijse.absd.channeling.service.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/speciality/")
public class SpecialityController {

    @Autowired
    private SpecialityService specialityService;

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllHospitals() {
        return ResponseEntity.ok(specialityService.getAll());
    }

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveHospitals(@RequestBody SpecialityDTO specialityDTO) {
        return ResponseEntity.ok(specialityService.add(specialityDTO));
    }

    @PutMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateHospitals(@RequestBody SpecialityDTO specialityDTO) {
        return ResponseEntity.ok(specialityService.update(specialityDTO));
    }

    @GetMapping(value = "/{specialityId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchHospitals(@PathVariable("specialityId") Integer specialityId) {
        return ResponseEntity.ok(specialityService.search(specialityId));
    }

    @DeleteMapping(value = "/{specialityId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteHospitals(@PathVariable("specialityId") Integer specialityId) {
        return ResponseEntity.ok(specialityService.delete(specialityId));
    }
}
