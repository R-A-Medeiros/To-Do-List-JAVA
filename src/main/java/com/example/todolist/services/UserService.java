package com.example.todolist.services;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.example.todolist.models.UserModel;
import com.example.todolist.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;

    public UserModel save(UserModel userModel) {
      var passwordHashred = BCrypt.withDefaults()
              .hashToString(12, userModel.getPassword().toCharArray());

      userModel.setPassword(passwordHashred);
      userModel = userRepository.save(userModel);
      return userModel;
    }
}
