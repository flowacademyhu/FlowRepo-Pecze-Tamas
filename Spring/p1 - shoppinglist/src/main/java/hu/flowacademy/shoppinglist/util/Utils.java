package hu.flowacademy.shoppinglist.util;

import hu.flowacademy.shoppinglist.domain.ShoppingListItem;
import hu.flowacademy.shoppinglist.domain.User;

import java.util.Map;

public class Utils {
    public static void logSL(Map<String, ShoppingListItem> sl) {
        System.out.println("**********************************************************");
        for (ShoppingListItem sli : sl.values()) {
            System.out.println(sli.toString());
        }
        System.out.println("**********************************************************");
    }
    public static void logUSR(Map<String, User> sl) {
        System.out.println("**********************************************************");
        for (User usr : sl.values()) {
            System.out.println(usr.toString());
        }
        System.out.println("**********************************************************");
    }
}
