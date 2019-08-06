package lk.ijse.absd.channeling.controller;

import lk.ijse.absd.channeling.dto.PaymentsDTO;
import lk.ijse.absd.channeling.service.PaymentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentsController {

    @Autowired
    private PaymentsService paymentsService;

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllPaymentss() {
        return ResponseEntity.ok(paymentsService.getAll());
    }

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity savePaymentss(@RequestBody PaymentsDTO paymentsDTO) {
        return ResponseEntity.ok(paymentsService.add(paymentsDTO));
    }

    @PutMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updatePaymentss(@RequestBody PaymentsDTO paymentsDTO) {
        return ResponseEntity.ok(paymentsService.update(paymentsDTO));
    }

    @GetMapping(value = "/{paymentsId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchPaymentss(@PathVariable("paymentsId") Integer paymentsId) {
        return ResponseEntity.ok(paymentsService.search(paymentsId));
    }

    @DeleteMapping(value = "/{paymentsId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deletePaymentss(@PathVariable("paymentsId") Integer paymentsId) {
        return ResponseEntity.ok(paymentsService.delete(paymentsId));
    }

}
