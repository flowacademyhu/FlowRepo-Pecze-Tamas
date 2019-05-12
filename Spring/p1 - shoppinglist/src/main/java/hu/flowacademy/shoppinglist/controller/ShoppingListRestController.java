package hu.flowacademy.shoppinglist.controller;

import hu.flowacademy.shoppinglist.domain.ShoppingItem;
import hu.flowacademy.shoppinglist.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/shoppinglist")
public class ShoppingListRestController {
    @Autowired
    private ShoppingService shoppingService;

    @PostMapping("/add")
    public ResponseEntity<ShoppingItem> addElement(@RequestBody ShoppingItem shoppingList) {
        return ResponseEntity.ok(shoppingService.save(shoppingList));
    }

    @PostMapping("/addlist")
    public ResponseEntity<List<ShoppingItem>> addElements(@RequestBody List<ShoppingItem> shoppingList) {
        return ResponseEntity.ok(shoppingService.saveList(shoppingList));
    }

    @PutMapping("/update")
    public ResponseEntity<ShoppingItem> updateElement(@RequestBody ShoppingItem shoppingList) {
        return ResponseEntity.ok(shoppingService.save(shoppingList));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteShoppingItem(@PathVariable String id) {
        shoppingService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/shoppingList")
    public ResponseEntity<List<ShoppingItem>> shoppingList() {
        return ResponseEntity.ok(shoppingService.listItems());

    }

    @GetMapping("/item/{id}")
    public ResponseEntity<ShoppingItem> getItemById(@PathVariable String id) {
        return ResponseEntity.ok(shoppingService.getOneItem(id));
    }

    @GetMapping("/sum")
    public ResponseEntity<Integer> sum() {
        return ResponseEntity.ok(shoppingService.sum());
    }

    @GetMapping("/count/{username}")
    public ResponseEntity<Long> getCount(@PathVariable String username) {
        return ResponseEntity.ok(shoppingService.getCount(username));
    }

    @GetMapping("getByUsername/{userName}")
    public ResponseEntity<List<ShoppingItem>> getSh(@PathVariable String userName) {
        return ResponseEntity.ok(shoppingService.getUserListByUserName(userName));
    }
    @GetMapping("startswith/{username}")
    public ResponseEntity<List<ShoppingItem>> getsh1(@PathVariable String username) {
        return ResponseEntity.ok(shoppingService.getUserStartingWith(username));
    }
}
