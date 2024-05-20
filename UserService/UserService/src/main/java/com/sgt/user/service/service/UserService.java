package com.sgt.user.service.service;

import com.sgt.user.service.entities.Rating;
import com.sgt.user.service.entities.User;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public interface UserService {
    User saveUser(User user);
    List<User> getAllUsers();
    User getUserById(String userId);
    User updateUser(String userId, User user);
    boolean deleteUserById(String userId);
    List<User> getOnlyUserListForFallBack();

}
