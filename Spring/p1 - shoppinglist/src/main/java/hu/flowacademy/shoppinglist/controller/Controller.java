package hu.flowacademy.shoppinglist.controller;

import hu.flowacademy.shoppinglist.service.Service;
import hu.flowacademy.shoppinglist.domain.ShoppingListItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/shoppinglist")
public class Controller {

    @Autowired
    private Service service;

    @PostMapping("/add")
    public ResponseEntity<ShoppingListItem> addsli(@RequestBody ShoppingListItem sli) {
        return ResponseEntity.ok(service.add(sli));
    }
    @PutMapping("/update")
    public ResponseEntity<ShoppingListItem> updatesli(@RequestBody ShoppingListItem sli) {
        return ResponseEntity.ok(service.save(sli));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletesli(@PathVariable String id) {
        return ResponseEntity.ok(service.delete(id));
    }
    @GetMapping("/listall")
    public ResponseEntity<List<ShoppingListItem>> listall(@RequestBody ShoppingListItem sli) {
        return ResponseEntity.ok(service.listall());
    }

}
