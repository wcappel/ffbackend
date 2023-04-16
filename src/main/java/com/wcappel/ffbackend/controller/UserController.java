package com.wcappel.ffbackend.controller;

import com.wcappel.ffbackend.auth.AuthTokenRequestBody;
import com.wcappel.ffbackend.auth.AuthUtils;
import com.wcappel.ffbackend.auth.GTokenValidator;
import com.wcappel.ffbackend.auth.ReturnedTokenInfo;
import com.wcappel.ffbackend.model.User;
import com.wcappel.ffbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// http://localhost:8080/ffapi/v1/users
@RestController @RequestMapping("/ffapi/v1/users") public class UserController {
    @Autowired private UserRepository userRepository;
    @Autowired private GTokenValidator gTokenValidator;

    @PostMapping("/authgetuserinfo")
    public User getUserInfo(@RequestBody AuthTokenRequestBody authTokenRequestBody) {
        String authToken = authTokenRequestBody.authToken;
        System.out.println(authToken);
        ReturnedTokenInfo tokenInfo = gTokenValidator.verifyGToken(authToken);
        User currentUser = AuthUtils.getUserInfo(tokenInfo, userRepository);
        if (tokenInfo.isValid() && currentUser != null) {
            System.out.println(currentUser);
            return currentUser;
        }
        System.out.println("User null");
        return null;
    }

    // http://localhost:8080/ffapi/v1/users/getallusers
    @GetMapping("/getallusers") public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
