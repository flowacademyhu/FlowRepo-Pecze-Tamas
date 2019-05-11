package hu.flowacademy.shoppinglist.repository;

import hu.flowacademy.shoppinglist.domain.User;
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
public class UserRepository {
    public Map<String, User> user_list = new HashMap<>();

    public User addusr(@RequestBody User usr) {
        user_list.put(usr.getUsername(), usr);
        Utils.logUSR(user_list);
        return usr;
    }
    public List<User> addusrList(@RequestBody List<User> usr) {
        for(var i: usr) {
            user_list.put(i.getUsername(), i);
        }
        Utils.logUSR(user_list);
        return usr;
    }
    public User updateusr(@RequestBody User usr) {
        User foundUSR = user_list.get(usr.getUsername());
        if (foundUSR != null) {
            user_list.remove(usr.getUsername());
            user_list.put(usr.getUsername(), usr);
            Utils.logUSR(user_list);
        }
        Utils.logUSR(user_list);
        return usr;
    }

    public String deleteusr(@PathVariable String usr) {
        if(user_list.get(usr) != null) {
            user_list.remove(usr);
            Utils.logUSR(user_list);
            return "Delete was successful. username:" + usr + " doesn't exist anymore.";
        } else {
            throw new ListItemNotFoundExeption(usr);
        }

    }

    public List<User> listAll() {
        Utils.logUSR(user_list);
        List<User> stuff = new ArrayList<>(user_list.values());
        return stuff;
    }

    public User returnUSR(@PathVariable String usr) {
        User foundUser = user_list.get(usr);
        return foundUser;

    }
   /* public Long count(Long usr) {
        User foundUser = user_list.get(usr);
        return foundUser;
    }*/
}
