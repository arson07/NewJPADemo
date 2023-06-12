package com.example.demo.User.Controller;

import com.example.demo.User.Entity.User;
import com.example.demo.User.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }
    @GetMapping("/sample-endpoint")
    public String sampleEndController(){
        return "Hello World";
    }

    @GetMapping("/users/all")
    public String getAllUsers(){
        return userService.getAllUser().toString();
    }

    @GetMapping("/user/{id}")
    public String getUser(@PathVariable int id){
        return userService.getUser(id).toString();
    }

    @DeleteMapping("/delete/user/{id}")
    public String deleteUser(@PathVariable int id){ return userService.deleteUser(id).toString();}

    @PutMapping("/update/user/{id}")
    public String updateUser(@PathVariable int id, @RequestBody User user){ return userService.updateUser(id, user).toString(); }

    @PostMapping("/insert/user")
    public String addUser(@RequestBody User user){
        return userService.addUser(user).toString();
    }
}

