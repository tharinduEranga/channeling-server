package lk.ijse.absd.channeling.controller;

import lk.ijse.absd.channeling.dto.PaymentsDTO;
import lk.ijse.absd.channeling.service.PaymentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/payments")
public class PaymentsController {

    @Autowired
    private PaymentsService paymentsService;

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllPayments() {
        return ResponseEntity.ok(paymentsService.getAll());
    }

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity savePayments(@RequestBody PaymentsDTO paymentsDTO) {
        return ResponseEntity.ok(paymentsService.add(paymentsDTO));
    }

    @PutMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updatePayments(@RequestBody PaymentsDTO paymentsDTO) {
        return ResponseEntity.ok(paymentsService.update(paymentsDTO));
    }

    @GetMapping(value = "/{paymentsId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchPayments(@PathVariable("paymentsId") Integer paymentsId) {
        return ResponseEntity.ok(paymentsService.search(paymentsId));
    }

    @DeleteMapping(value = "/{paymentsId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deletePayments(@PathVariable("paymentsId") Integer paymentsId) {
        return ResponseEntity.ok(paymentsService.delete(paymentsId));
    }

}
