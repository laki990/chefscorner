package com.lnikolic.chefscorner.service;

import com.lnikolic.chefscorner.entity.User;
import com.lnikolic.chefscorner.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }
}
