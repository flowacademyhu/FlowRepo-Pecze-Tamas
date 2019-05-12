package hu.flowacademy.shoppinglist.service;

import hu.flowacademy.shoppinglist.domain.User;
import hu.flowacademy.shoppinglist.exception.ListItemNotFoundException;
import hu.flowacademy.shoppinglist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public List<User> saveUserList(List<User> users) {
        List<User> list = new ArrayList<>();
        for (var i: users) {
            if(i.getUserName() != null) {
                userRepository.save(i);
                list.add(i);
            }
        }
        return list;

    }

    public void deleteById(String username) {
        try {
            userRepository.deleteById(username);
        } catch (EmptyResultDataAccessException e) {
            throw new ListItemNotFoundException(username);
        }
    }

    public List<User> getlistUsers() {
        return userRepository.findAll();
    }

    public User getOneUser(String username) {
        if (userRepository.findById(username).isPresent()) {
            return userRepository.findById(username).get();
        }
        throw new ListItemNotFoundException(username);
    }


}