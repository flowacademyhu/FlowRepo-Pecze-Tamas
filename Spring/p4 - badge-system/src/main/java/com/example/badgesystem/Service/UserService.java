package com.example.badgesystem.Service;

import com.example.badgesystem.Domain.User;
import com.example.badgesystem.Exception.ValidationErrorUsernameEmpty;
import com.example.badgesystem.Exception.ValidationErrorUsernameNotUnique;
import com.example.badgesystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User save(User user){
        if(user.getUsername() == null){
            throw new ValidationErrorUsernameEmpty();
        }
        List<User> templist = userRepository.findAll();
        boolean found = false;
        for (int i = 0; i < templist.size(); i++) {
            if(templist.get(i).getUsername().equals(user.getUsername())){
                found = true;
            }
        }
        if(found){
            throw new ValidationErrorUsernameNotUnique(user.getUsername());
        }
        return userRepository.save(user);
    }
    public List<User> listAll() {
        return userRepository.findAll();
    }
    /*public User getBadgeToUserId(String UserId, String badgeId) {
        userRepository.findById(UserId).
        return userRepository.
    }*/
}
