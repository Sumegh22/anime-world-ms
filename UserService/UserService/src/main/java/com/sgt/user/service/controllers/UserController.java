package com.sgt.user.service.controllers;

import com.sgt.user.service.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    //create

    public ResponseEntity<User> createUser(@RequestBody User user){

    }


}
