package lk.ijse.absd.channeling.controller;

import lk.ijse.absd.channeling.dto.BrandDTO;
import lk.ijse.absd.channeling.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/brands/")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllBrands() {
        return ResponseEntity.ok(brandService.getAll());
    }

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveBrands(@RequestBody BrandDTO brandDTO) {
        return ResponseEntity.ok(brandService.add(brandDTO));
    }

    @PutMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateBrands(@RequestBody BrandDTO brandDTO) {
        return ResponseEntity.ok(brandService.update(brandDTO));
    }

    @GetMapping(value = "/{brandId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchBrands(@PathVariable("brandId") Integer brandId) {
        return ResponseEntity.ok(brandService.search(brandId));
    }

    @DeleteMapping(value = "/{brandId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteBrands(@PathVariable("brandId") Integer brandId) {
        return ResponseEntity.ok(brandService.delete(brandId));
    }
}
