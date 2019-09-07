package lk.ijse.absd.channeling.controller;

import lk.ijse.absd.channeling.dto.AppointmentsDTO;
import lk.ijse.absd.channeling.dto.util.CommonResponse;
import lk.ijse.absd.channeling.service.AppointmentsService;
import lk.ijse.absd.channeling.util.ChannelingException;
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
    public ResponseEntity getAllAppointments() {
        return ResponseEntity.ok(appointmentsService.getAll());
    }

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveAppointments(@RequestBody AppointmentsDTO appointmentsDTO) {
        try {
            return ResponseEntity.ok(appointmentsService.add(appointmentsDTO));
        } catch (ChannelingException c) {
            return ResponseEntity.ok(new CommonResponse<>(false, c.getMessage()));
        }
    }

    @PutMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateAppointments(@RequestBody AppointmentsDTO appointmentsDTO) {
        try {
            return ResponseEntity.ok(appointmentsService.update(appointmentsDTO));
        } catch (ChannelingException c) {
            return ResponseEntity.ok(new CommonResponse<>(false, c.getMessage()));
        }
    }

    @GetMapping(value = "/{appointmentsId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchAppointments(@PathVariable("appointmentsId") Integer appointmentsId) {
        return ResponseEntity.ok(appointmentsService.search(appointmentsId));
    }

    @DeleteMapping(value = "/{appointmentsId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteAppointments(@PathVariable("appointmentsId") Integer appointmentsId) {
        return ResponseEntity.ok(appointmentsService.delete(appointmentsId));
    }

    @GetMapping(value = "/future", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getFutureAppointments() {
        return ResponseEntity.ok(appointmentsService.getFutureAppointments());
    }

}
