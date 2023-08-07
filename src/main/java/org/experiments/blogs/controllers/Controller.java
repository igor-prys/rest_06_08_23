package org.experiments.blogs.controllers;

import org.experiments.blogs.entities.User;
import org.experiments.blogs.exception.handling.NoSuchUserException;
import org.experiments.blogs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public void saveUser(@RequestBody User user) {
        userService.saveOrUpdateUser(user);
    }

    @PutMapping("/users")
    public void updateUser(@RequestBody User user) {
        if(user.getId()==null){
            throw new RuntimeException("user does not exist");
        }
       Optional<User> oldUser=userService.getUser(user.getId());
       if(!oldUser.isPresent()){
           throw new RuntimeException("user does not exist");
       }
        userService.saveOrUpdateUser(user);
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable  Long id) {
       Optional<User> user=userService.getUser(id);
       if(!user.isPresent()){
           throw  new NoSuchUserException("Incorrect index");
       }
       return user.get();
    }

    @GetMapping("/users")
    public List<User> getAll() {
        return userService.getAll();
    }

    @DeleteMapping("/users/{id}")
   public boolean deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }

}


