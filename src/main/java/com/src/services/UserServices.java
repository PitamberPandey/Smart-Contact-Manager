package com.src.services;

import java.util.List;
import java.util.Optional;

import com.src.enitities.User;

public interface UserServices {
    User saveUser(User user);
    Optional<User> getUserByid(String id);
    Optional<User> updateUser(User user);
    void deleteUser(String id);
    boolean isUserExist(String id);
    boolean isUserExistByEmail(String email);
    List<User>getAllUsers();

}
