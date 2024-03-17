package com.sgt.user.service.controllers;

import com.sgt.user.service.entities.User;
import com.sgt.user.service.service.UserService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    //create
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User newUser = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    // get Single user
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable String userId){
        User requestedUser = userService.getUserById(userId);
        return ResponseEntity.ok(requestedUser);
    }

    // get All user
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> allUserList = userService.getAllUsers();
        return ResponseEntity.ok(allUserList);
    }


}
