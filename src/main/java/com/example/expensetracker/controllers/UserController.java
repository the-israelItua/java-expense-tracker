package com.example.expensetracker.controllers;

import com.example.expensetracker.entity.User;
import com.example.expensetracker.entity.UserModel;
import com.example.expensetracker.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    ResponseEntity<User> registerUser(@RequestBody @Valid UserModel user){
        User createdUser = userService.createUser(user);
        return new ResponseEntity<User>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping("/user/me")
    ResponseEntity<User> fetchUser(@RequestParam String email){
        User user = userService.fetchMe(email);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @PutMapping("/user/update")
    ResponseEntity<User> updateUser(@RequestBody User user, @RequestParam String email){
        User updatedUser = userService.updateUser(user, email);
        return new ResponseEntity<User>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/user/delete")
    ResponseEntity<String> deleteUser(@RequestParam String email){
        userService.deleteUser(email);
        return new ResponseEntity<String>("Account deleted successfully.", HttpStatus.OK);
    }


}
