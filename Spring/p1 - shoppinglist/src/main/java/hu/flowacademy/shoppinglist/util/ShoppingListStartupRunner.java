package hu.flowacademy.shoppinglist.util;

import hu.flowacademy.shoppinglist.domain.ShoppingListItem;
import hu.flowacademy.shoppinglist.domain.User;
import hu.flowacademy.shoppinglist.repository.ShoppingListRepository;
import hu.flowacademy.shoppinglist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class ShoppingListStartupRunner implements CommandLineRunner {

    @Autowired
    private ShoppingListRepository shoppingListRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User user1 = new User("dalecooper", "sarkany1", "Dale Cooper");
        User user2 = new User("gordoncole", "viaszbabu2", "Gordon Cole");

        ShoppingListItem task1 = new ShoppingListItem("EX1", "Find out who killed Laura Palmer", false, user1);
        ShoppingListItem task2 = new ShoppingListItem("EX2", "Drink a DAMN fine cup of coffee", true, user1);
        ShoppingListItem task3 = new ShoppingListItem("EX3", "Have a meeting with Dale", false, user2);
        ShoppingListItem task4 = new ShoppingListItem("EX4", "Ask Dianne to check my savings", true, user1);

        userRepository.updateusr(user1);
        userRepository.updateusr(user2);

        shoppingListRepository.updatesl(task1);
        shoppingListRepository.updatesl(task2);
        shoppingListRepository.updatesl(task3);
        shoppingListRepository.updatesl(task4);
    }
}
