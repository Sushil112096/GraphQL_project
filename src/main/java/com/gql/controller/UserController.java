package com.gql.controller;

import com.gql.entities.User;
import com.gql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @QueryMapping
    public List<User> getusers() {
        return userService.getallusers();
    }

    @QueryMapping
    public User getsingleuser(@Argument int Id) {
        return userService.getsingleuser(Id);
    }

    @MutationMapping
    public User createUser(@Argument String name, @Argument String email, @Argument String phone) {
        User user = new User();
        user.setEmail(email);
        user.setName(name);
        user.setPhone(phone);
        return userService.saveuser(user);
    }

    @MutationMapping
    public boolean deleteUser(@Argument int Id) {
        userService.deleteuser(Id);
        return true;
    }
}
