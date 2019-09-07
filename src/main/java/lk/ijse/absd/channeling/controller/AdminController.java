package lk.ijse.absd.channeling.controller;

import lk.ijse.absd.channeling.dto.AdminDTO;
import lk.ijse.absd.channeling.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity login(@RequestBody AdminDTO adminDTO) {
        return ResponseEntity.ok(adminService.login(adminDTO));
    }

}
