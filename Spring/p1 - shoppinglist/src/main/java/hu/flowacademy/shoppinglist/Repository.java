package hu.flowacademy.shoppinglist;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@org.springframework.stereotype.Repository
public class Repository {

    public Map<String, ShoppingListItem> sl = new HashMap<>(); //sl stands for ShoppingList


    public ShoppingListItem addsl(@RequestBody ShoppingListItem sli) {
        sl.put(sli.getId(), sli);
        log();
        return sli;
    }
    public List<ShoppingListItem> addslList(@RequestBody List<ShoppingListItem> sli) {
        for(var i: sli) {
            sl.put(i.getId(), i);
        }
        log();
        return sli;
    }
    public ShoppingListItem updatesl(@RequestBody ShoppingListItem sli) {
        ShoppingListItem foundSLI = sl.get(sli.getId());
        if (foundSLI != null) {
            sl.remove(sli.getId());
            sl.put(sli.getId(), sli);
            log();
        }
        log();
        return sli;
    }

    public String deletesl(@PathVariable String id) {
        if(sl.get(id) != null) {
            sl.remove(id);
            log();
            return "Delete was successful. Id:" + id + " doesn't exist anymore.";
        } else {
            throw new ListItemNotFoundExeption(id);
        }

    }

    public List<ShoppingListItem> listAll() {
        log();
        List<ShoppingListItem> stuff = new ArrayList<>(sl.values());
        return stuff;
    }

    private void log() {
        System.out.println("**********************************************************");
        for (ShoppingListItem sli : sl.values()) {
            System.out.println(sli.toString());
        }
        System.out.println("**********************************************************");
    }
}
