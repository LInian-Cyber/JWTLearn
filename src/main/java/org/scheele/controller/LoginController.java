package org.scheele.controller;

import org.scheele.config.ResponseResult;
import org.scheele.domain.User;
import org.scheele.service.LoginServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private LoginServcie loginServcie;
    @PostMapping("/user/login")
    public ResponseResult login(@RequestBody User user){
        return loginServcie.login(user);
    }
}
