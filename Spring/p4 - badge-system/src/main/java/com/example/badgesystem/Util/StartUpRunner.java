package com.example.badgesystem.Util;

import com.example.badgesystem.Domain.Badge;
import com.example.badgesystem.Domain.User;
import com.example.badgesystem.Repository.BadgeRepository;
import com.example.badgesystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartUpRunner implements CommandLineRunner {

    @Autowired
    private BadgeRepository badgeRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        Badge b1 = new Badge("Best colleauge","The very best","User1");
        Badge b2 = new Badge("Best employee of the month","Hard worker...","User1");

        User u1 = new User("Andorka1","Hajnal Java Andor","wqe","Java expert");
        User u2 = new User("Tamaska22","Viczian Spring Tamas","lovespring","Spring expert");

        userRepository.save(u1);
        userRepository.save(u2);

        badgeRepository.save(b1);
        badgeRepository.save(b2);
    }
}
