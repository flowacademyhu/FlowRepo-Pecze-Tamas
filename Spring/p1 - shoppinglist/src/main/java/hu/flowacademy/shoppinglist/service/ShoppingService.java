package hu.flowacademy.shoppinglist.service;

import hu.flowacademy.shoppinglist.exception.ListItemNotFoundException;
import hu.flowacademy.shoppinglist.repository.ShoppingListRepository;
import hu.flowacademy.shoppinglist.domain.ShoppingItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShoppingService {

    @Autowired
    private ShoppingListRepository shoppingListRepository;

    public ShoppingItem save(ShoppingItem shoppingItem) {
        return shoppingListRepository.save(shoppingItem);
    }

    public List<ShoppingItem> saveList(List<ShoppingItem> shoppingList) {
        List<ShoppingItem> list = new ArrayList<>();
        for (var i: shoppingList) {
            if(i.getId() != null) {
                shoppingListRepository.save(i);
                list.add(i);
            }
        }
        return list;

    }

    public void delete(String id) {
        try {
            shoppingListRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ListItemNotFoundException(id);
        }
    }

    public List<ShoppingItem> listItems() {
        return shoppingListRepository.findAll();
    }

    public int sum() {
        return shoppingListRepository.sumprice();
    }

    public ShoppingItem getOneItem(String id) {
        if (shoppingListRepository.findById(id).isPresent()) {
            return shoppingListRepository.findById(id).get();
        }
        throw new ListItemNotFoundException(id);
    }

    public long getCount(String username) {
        return shoppingListRepository.getCount(username);
    }

    public List<ShoppingItem> getUserListByUserName(String username) {
        return shoppingListRepository.findByUser_userName(username);
    }

    public List<ShoppingItem> getUserStartingWith(String username) {
        return shoppingListRepository.findByUser_userNameStartingWithOrderByName(username);
    }


}