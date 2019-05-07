package hu.flowacademy.shoppinglist.util;

import hu.flowacademy.shoppinglist.domain.ShoppingListItem;

import java.util.HashMap;
import java.util.Map;

public class Utils {
    public static void log(Map<String, ShoppingListItem> sl) {
        System.out.println("**********************************************************");
        for (ShoppingListItem sli : sl.values()) {
            System.out.println(sli.toString());
        }
        System.out.println("**********************************************************");
    }
}
