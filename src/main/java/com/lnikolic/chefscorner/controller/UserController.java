package com.lnikolic.chefscorner.controller;

import com.lnikolic.chefscorner.dto.CreateUser;
import com.lnikolic.chefscorner.dto.UserData;
import com.lnikolic.chefscorner.entity.User;
import com.lnikolic.chefscorner.mapper.UserMapper;
import com.lnikolic.chefscorner.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<UserData>> getAllUsers() {
        List<User> allUsers = this.userService.getAllUsers();
        List<UserData> userData = UserMapper.INSTANCE.getAllUsers(allUsers);

        return new ResponseEntity<>(userData, HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<UserData> getUserById(@RequestParam Long id) {
        User user = this.userService.getUserById(id);
        UserData userData = UserMapper.INSTANCE.userToUserResponseDto(user);

        return new ResponseEntity<>(userData, HttpStatus.OK);
    }
}
