package hu.flowacademy.shoppinglist.repository;

import hu.flowacademy.shoppinglist.domain.ShoppingItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShoppingListRepository extends JpaRepository<ShoppingItem, String> {

    public void deleteById(String id);

    @Query("SELECT SUM(shoppingItem.price) FROM ShoppingItem shoppingItem")
    public int sumprice();

    @Query("SELECT COUNT(shoppingItem) FROM ShoppingItem shoppingItem WHERE shoppingItem.user.userName = ?1")
    public long getCount(String username);

    public List<ShoppingItem> findByUser_userName(String login);

    public List<ShoppingItem> findByUser_userNameStartingWithOrderByName(String login);
}
