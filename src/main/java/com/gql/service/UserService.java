package com.gql.service;

import com.gql.entities.User;
import com.gql.exceptionhelper.ExceptionHelper;
import com.gql.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    //create
    public User saveuser(User user) {
        return userRepo.save(user);
    }

    //findall
    public List<User> getallusers() {
        return userRepo.findAll();
    }

    //single
    public User getsingleuser(int id) {
        return userRepo.findById(id).orElseThrow(ExceptionHelper::usernotfound);
    }
    //update

    //delete
    public boolean deleteuser(int id) {
        User user = userRepo.findById(id).orElseThrow(ExceptionHelper::usernotfound);
        userRepo.delete(user);
        return true;
    }
}
