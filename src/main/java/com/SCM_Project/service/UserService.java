package com.SCM_Project.service;

import java.util.List;
import java.util.Optional;

import com.SCM_Project.entities.User;

public interface  UserService {

    User saveUser(User user);
    Optional<User> getUserById(int id);
    User getUserByEmail(String email);
    Optional<User> updateUser(User user,int id);
    void deleteUser(int id);
    boolean isUserPresent(int userId);
    boolean isUserPresentByEmail(String email);
    List<User> getAllUsers();



}
