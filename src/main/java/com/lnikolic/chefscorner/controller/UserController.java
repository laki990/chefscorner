package com.lnikolic.chefscorner.controller;

import com.lnikolic.chefscorner.dto.CreateUser;
import com.lnikolic.chefscorner.entity.User;
import com.lnikolic.chefscorner.mapper.UserMapper;
import com.lnikolic.chefscorner.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody CreateUser createUser) {
        User user = UserMapper.INSTANCE.userCreateDtoToUser(createUser);
        var newUser = userService.addUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
