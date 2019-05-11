package hu.flowacademy.shoppinglist.repository;

import hu.flowacademy.shoppinglist.domain.ShoppingListItem;
import hu.flowacademy.shoppinglist.exception.ListItemNotFoundExeption;
import hu.flowacademy.shoppinglist.util.Utils;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ShoppingListRepository {

    public Map<String, ShoppingListItem> sl = new HashMap<>(); //sl stands for ShoppingList


    public ShoppingListItem addsl(@RequestBody ShoppingListItem sli) {
        sl.put(sli.getId(), sli);
        Utils.logSL(sl);
        return sli;
    }
    public List<ShoppingListItem> addslList(@RequestBody List<ShoppingListItem> sli) {
        for(var i: sli) {
            sl.put(i.getId(), i);
        }
        Utils.logSL(sl);
        return sli;
    }
    public ShoppingListItem updatesl(@RequestBody ShoppingListItem sli) {
        ShoppingListItem foundSLI = sl.get(sli.getId());
        if (foundSLI != null) {
            sl.remove(sli.getId());
            sl.put(sli.getId(), sli);
            Utils.logSL(sl);
        }
        Utils.logSL(sl);
        return sli;
    }

    public String deletesl(@PathVariable String id) {
        if(sl.get(id) != null) {
            sl.remove(id);
            Utils.logSL(sl);
            return "Delete was successful. Id:" + id + " doesn't exist anymore.";
        } else {
            throw new ListItemNotFoundExeption(id);
        }

    }

    public List<ShoppingListItem> listAll() {
        Utils.logSL(sl);
        List<ShoppingListItem> stuff = new ArrayList<>(sl.values());
        return stuff;
    }
}
