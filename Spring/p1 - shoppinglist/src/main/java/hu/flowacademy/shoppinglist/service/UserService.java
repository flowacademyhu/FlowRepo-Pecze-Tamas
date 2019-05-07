package hu.flowacademy.shoppinglist.service;

import hu.flowacademy.shoppinglist.domain.User;
import hu.flowacademy.shoppinglist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User add (User usr){ return userRepository.addusr(usr); }
    public User save (User usr){ return userRepository.updateusr(usr); }
    public String delete (String s){ return userRepository.deleteusr(s); }
    public List<User> listall () { return userRepository.listAll(); }
    public User find (String s){ return userRepository.returnUSR(s); }
}
