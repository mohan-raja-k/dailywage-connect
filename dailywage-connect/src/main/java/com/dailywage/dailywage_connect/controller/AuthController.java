package com.dailywage.dailywage_connect.controller;

import com.dailywage.dailywage_connect.JwtUtil;
import com.dailywage.dailywage_connect.model.UserModel;
import com.dailywage.dailywage_connect.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/Auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepository ur;

    @PostMapping("/login")
    public String login(@RequestBody UserModel user) {
        List<UserModel> users = ur.findAll();
        for (UserModel u : users) {
            if (u.getUserEmail().equals(user.getUserEmail()) &&
                    u.getUserPassword().equals(user.getUserPassword())) {
                return jwtUtil.generateToken(u.getUserEmail());
            }
        }
        return "Invalid email or password!";
    }
}