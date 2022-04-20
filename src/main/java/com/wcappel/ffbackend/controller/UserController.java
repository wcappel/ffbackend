package com.wcappel.ffbackend.controller;

import com.wcappel.ffbackend.model.User;
import com.wcappel.ffbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// http://localhost:8080/ffapi/v1/users
@RestController @RequestMapping("/ffapi/v1/users") public class UserController {
    @Autowired private UserRepository userRepository;

    // http://localhost:8080/ffapi/v1/users/getallusers
    @GetMapping("/getallusers") public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
