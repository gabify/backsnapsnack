package com.gabify.co.backsnapsnack.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.gabify.co.backsnapsnack.Model.UserModel;

@RestController
public class UserController {
    
    //Fetch One data
    //http:localhost:8080/user
    @GetMapping("/user")
    public UserModel getUser(){
        return new UserModel(1, "jeven 11", "jeven.11@email.com", "jeven11");
    }

    //Fetch multiple data
    //http://localhost:8080/users
    @GetMapping("/users")
    public List<UserModel> getUsers(){
        List<UserModel> users = new ArrayList<>();
        users.add(new UserModel(1, "Mario", "mario@email.com", "mario"));
        users.add(new UserModel(2, "Luigi", "luigi@email.com", "luigi"));
        users.add(new UserModel(3, "Yoshi", "yoshi@email.com", "yoshi"));
        return users;
        
    }
    //http://localhost:8080/user/juan
    @GetMapping("/user/{name}")
    public UserModel getUserFromName(@PathVariable("name")String name){
        return new UserModel(1, "Juan", "juan@email.com", "juan");
    }

    
}
