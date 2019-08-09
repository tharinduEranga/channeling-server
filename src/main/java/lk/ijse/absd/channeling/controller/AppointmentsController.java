package lk.ijse.absd.channeling.controller;

import lk.ijse.absd.channeling.dto.AppointmentsDTO;
import lk.ijse.absd.channeling.service.AppointmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/appointments/")
public class AppointmentsController {

    @Autowired
    private AppointmentsService appointmentsService;

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllHospitals() {
        return ResponseEntity.ok(appointmentsService.getAll());
    }

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveHospitals(@RequestBody AppointmentsDTO appointmentsDTO) {
        return ResponseEntity.ok(appointmentsService.add(appointmentsDTO));
    }

    @PutMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateHospitals(@RequestBody AppointmentsDTO appointmentsDTO) {
        return ResponseEntity.ok(appointmentsService.update(appointmentsDTO));
    }

    @GetMapping(value = "/{appointmentsId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchHospitals(@PathVariable("appointmentsId") Integer appointmentsId) {
        return ResponseEntity.ok(appointmentsService.search(appointmentsId));
    }

    @DeleteMapping(value = "/{appointmentsId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteHospitals(@PathVariable("appointmentsId") Integer appointmentsId) {
        return ResponseEntity.ok(appointmentsService.delete(appointmentsId));
    }

}
