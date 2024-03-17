package com.sgt.user.service.service.impl;

import com.sgt.user.service.entities.User;
import com.sgt.user.service.exceptions.ResourceNotFoundException;
import com.sgt.user.service.repositories.UserRepository;
import com.sgt.user.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        String randomUserID = UUID.randomUUID().toString();
        user.setUserId(randomUserID);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(String userId) {
        return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given id could not be found !..  : "+userId));
    }

    @Override
    public boolean deleteUser(String userId) {
        return false;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }
}
