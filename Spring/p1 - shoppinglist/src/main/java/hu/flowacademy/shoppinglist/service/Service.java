package hu.flowacademy.shoppinglist.service;

import hu.flowacademy.shoppinglist.repository.ShoppingListRepository;
import hu.flowacademy.shoppinglist.domain.ShoppingListItem;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private ShoppingListRepository shoppingListRepository;


    public ShoppingListItem save (ShoppingListItem sli) {
        return shoppingListRepository.updatesl(sli);
    }
    public ShoppingListItem add (ShoppingListItem sli) {
        return shoppingListRepository.addsl(sli);
    }
    public String delete (String s) {
        return shoppingListRepository.deletesl(s);
    }

    public List<ShoppingListItem> listall () {
        return shoppingListRepository.listAll();
    }

}
