package hu.flowacademy.shoppinglist.controller;

import hu.flowacademy.shoppinglist.domain.Variant;
import hu.flowacademy.shoppinglist.service.VariantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/variant")
public class VariantController {

    @Autowired
    private VariantService variantService;

    @GetMapping("/getall")
    public ResponseEntity<List<Variant>> getAllVariants() {
        return ResponseEntity.ok(variantService.getAllElements());
    }
    @PostMapping
    public ResponseEntity<Variant> add(Variant variant) {
        return ResponseEntity.ok(variantService.saveElement(variant));
    }
    @PutMapping
    public ResponseEntity<Variant> update(Variant variant) {
        return ResponseEntity.ok(variantService.saveElement(variant));
    }

    @GetMapping
    public ResponseEntity<Double> sumPrice(String id) {
        return ResponseEntity.ok(variantService.sumPrice(id));
    }

    @GetMapping("/groupped")
    public ResponseEntity<List<Variant>> listVariants() {
        return ResponseEntity.ok(variantService.listVariants());
    }
}