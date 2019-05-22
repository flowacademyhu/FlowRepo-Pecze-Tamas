package com.example.badgesystem.Controller;

import com.example.badgesystem.Domain.Badge;
import com.example.badgesystem.Service.BadgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/badges")
public class BadgeController {
    @Autowired
    private BadgeService badgeService;
    @PostMapping("/add")
    public ResponseEntity<Badge> addBadge(@RequestBody Badge badge) {
        return ResponseEntity.ok(badgeService.save(badge));
    }
    @PutMapping("/update")
    public ResponseEntity<Badge> update(@RequestBody Badge badge) {
        return ResponseEntity.ok(badgeService.save(badge));
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Badge>> getAllBadges() {
        return ResponseEntity.ok(badgeService.getAll());
    }
}
