package hu.flowacademy.Bidder.application.Controller;

import hu.flowacademy.Bidder.application.Domain.Product;
import hu.flowacademy.Bidder.application.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.save(product));
    }
    @GetMapping("/get")
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(productService.getAll());
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Product> getOneProduct(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getOneProduct(id));
    }

}
