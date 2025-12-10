package com.example.todolist.controllers;

import com.example.todolist.models.UserModel;
import com.example.todolist.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user")
    public ResponseEntity<UserModel> create(@RequestBody UserModel userModel) {
        var user = this.userService.save(userModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
