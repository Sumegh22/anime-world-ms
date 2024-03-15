package com.sgt.user.service.service;

import com.sgt.user.service.entities.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    List<User> getAllUsers();

    User getUserById(String userId);

    boolean deleteUser(String userId);

    User updateUser(User user);



}
