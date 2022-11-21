package com.persistence.services;

import com.persistence.entities.User;

import java.util.List;

public interface UserManagementService {

    void registerUser(User user);
    User getUser(String email,String password);
    User getUserById(int id);
    List<User> getAllUser();

}
