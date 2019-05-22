package com.example.badgesystem.Service;

import com.example.badgesystem.Domain.Badge;
import com.example.badgesystem.Exception.ValidationErrorBadgeNameNotUnique;
import com.example.badgesystem.Exception.ValidationErrorUsernameNotUnique;
import com.example.badgesystem.Repository.BadgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BadgeService {
    @Autowired
    private BadgeRepository badgeRepository;

    public Badge save(Badge badge) {
        List<Badge> templist = badgeRepository.findAll();
        boolean found = false;
        for (int i = 0; i < templist.size(); i++) {
            if(templist.get(i).getName().equals(badge.getName())){
                found = true;
            }
        }
        if(found){
            throw new ValidationErrorBadgeNameNotUnique(badge.getName());
        }
        return badgeRepository.save(badge);
    }
    public List<Badge> getAll() {
        return badgeRepository.findAll();
    }
    public Badge getBadgeByName(String badgename) {
        return badgeRepository.findByBadgeName(badgename);
    }

}
