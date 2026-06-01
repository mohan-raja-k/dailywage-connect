package com.dailywage.dailywage_connect.controller;

import com.dailywage.dailywage_connect.model.UserModel;
import com.dailywage.dailywage_connect.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/User")
@RestController
public class UserController {
    @Autowired
    UserService us;
    @PostMapping("/addUser")
    public UserModel addUser(@RequestBody UserModel uM)
    {
        return us.addUser(uM);
    }
    @GetMapping("/getUser")
    public List<UserModel> getAllUser()
    {
        return us.getAllUser();

    }
    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable Long id)
    {
        return us.deleteUser(id);
    }
    @PutMapping("/updateUser/{id}")
    public UserModel updateUser(@RequestBody UserModel uM,@PathVariable Long id)
    {
        return us.updateUser(uM,id);
    }
    @GetMapping("/getUserByCity")
    public List<UserModel> getBycity(@RequestParam("city") String city)
    {
        return us.searchBycity(city);
    }
    @GetMapping("/getUserByRole")
    public List<UserModel> getByrole(@RequestParam("role") String role)
    {
        return us.searchByrole(role);
    }
}
