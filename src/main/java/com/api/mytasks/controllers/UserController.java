package com.api.mytasks.controllers;

import com.api.mytasks.entity.User;
import com.api.mytasks.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;
    public UserController(UserService userService){this.userService = userService;}

    @GetMapping
    public List<User> findAllUsers(){return userService.findAllUsers(); }

    @GetMapping(value = "/{id}")
    public User findUser(@PathVariable UUID id){return userService.findUser(id);}
    @PostMapping
    public User insertUser(@RequestBody User from){return userService.insertUser(from);}

    @DeleteMapping(value = "/{id}")
    public User deleteUser(@PathVariable UUID id){return userService.deleteUser(id);}

    @PutMapping(value = "/{id}")
    public User updateUser(@PathVariable UUID id, @RequestBody User from){return userService.updateUser(id,from);}
}
