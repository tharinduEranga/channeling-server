package lk.ijse.absd.channeling.controller;

import lk.ijse.absd.channeling.dto.DaysDTO;
import lk.ijse.absd.channeling.service.DaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/days/")
public class DaysController {

    @Autowired
    private DaysService daysService;

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllHospitals() {
        return ResponseEntity.ok(daysService.getAll());
    }

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveHospitals(@RequestBody DaysDTO daysDTO) {
        return ResponseEntity.ok(daysService.add(daysDTO));
    }

    @PutMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateHospitals(@RequestBody DaysDTO daysDTO) {
        return ResponseEntity.ok(daysService.update(daysDTO));
    }

    @GetMapping(value = "/{daysId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchHospitals(@PathVariable("daysId") Integer daysId) {
        return ResponseEntity.ok(daysService.search(daysId));
    }

    @DeleteMapping(value = "/{daysId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteHospitals(@PathVariable("daysId") Integer daysId) {
        return ResponseEntity.ok(daysService.delete(daysId));
    }
}
