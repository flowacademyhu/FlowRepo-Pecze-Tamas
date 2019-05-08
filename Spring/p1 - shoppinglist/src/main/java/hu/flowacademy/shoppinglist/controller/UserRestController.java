package hu.flowacademy.shoppinglist.controller;

import hu.flowacademy.shoppinglist.domain.User;
import hu.flowacademy.shoppinglist.repository.UserRepository;
import hu.flowacademy.shoppinglist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import hu.flowacademy.shoppinglist.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping(path = "/userlist")
public class UserRestController {


        @Autowired
        private UserService userRestController;

        @PostMapping("/add")
        public ResponseEntity<User> addusr(@RequestBody User usr) {
            return ResponseEntity.ok(userRestController.add(usr));
        }
        @PutMapping("/update")
        public ResponseEntity<User> updateusr(@RequestBody User usr) {
            return ResponseEntity.ok(userRestController.save(usr));
        }
        @DeleteMapping("/delete/{usr}")
        public ResponseEntity<String> deleteusr(@PathVariable String usr) {
            return ResponseEntity.ok(userRestController.delete(usr));
        }
        @GetMapping("/listall")
        public ResponseEntity<List<User>> listusr(@RequestBody User usr) {
            return ResponseEntity.ok(userRestController.listall());
        }
        @GetMapping("/find/{usr}")
        public ResponseEntity<User> findusr(@PathVariable String usr) {
            return ResponseEntity.ok(userRestController.find(usr));
        }
        @GetMapping("/countall")
        public ResponseEntity<List<User>> count(@PathVariable String usr) {
            return ResponseEntity.ok(userRestController.count(usr));
    }
}
