package com.example.todolist.services;

import com.example.todolist.models.UserModel;
import com.example.todolist.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;

    public UserModel save(UserModel userModel) {
        userModel = userRepository.save(userModel);
        return userModel;
    }
}
