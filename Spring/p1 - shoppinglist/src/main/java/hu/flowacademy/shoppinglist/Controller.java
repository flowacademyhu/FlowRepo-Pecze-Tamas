package hu.flowacademy.shoppinglist;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(path = "/shoppinglist")
public class Controller {
    private Map<String, ShoppingListItem> sl = new HashMap<>(); //sl stands for ShoppingList

    @PostMapping("/add")
    public ResponseEntity<ShoppingListItem>addsl(@RequestBody ShoppingListItem sli) {
        sl.put(sli.getId(), sli);
        log();
        return ResponseEntity.ok(sli);
    }
    @PostMapping("/addList")
    public ResponseEntity<List<ShoppingListItem>>addslList(@RequestBody List<ShoppingListItem> sli) {
        for(var i: sli) {
            sl.put(i.getId(), i);
        }
        log();
        return ResponseEntity.ok(sli);
    }
    @PutMapping("/update")
    public ResponseEntity<ShoppingListItem>updatesl(@RequestBody ShoppingListItem sli) {
        ShoppingListItem foundSLI = sl.get(sli.getId());
        if (foundSLI != null) {
            sl.remove(sli.getId());
            sl.put(sli.getId(), sli);
            log();
        }
        log();
        return ResponseEntity.ok(sli);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String>deletesl(@PathVariable String id) {
        sl.remove(id);
        log();
        return ResponseEntity.ok("Delete was successful. Id:" + id + " doesn't exist anymore.");
    }
    @GetMapping("/getall")
    public ResponseEntity<List<ShoppingListItem>>listAll() {
        log();
        List<ShoppingListItem> stuff = new ArrayList<>(sl.values());
        return ResponseEntity.ok(stuff);
    }

    private void log() {
        System.out.println("**********************************************************");
        for (ShoppingListItem sli : sl.values()) {
            System.out.println(sli.toString());
        }
        System.out.println("**********************************************************");
    }
}
