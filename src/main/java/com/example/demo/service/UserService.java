package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(int id);

    void signup(User user);

    User login(String email, String password,String role);

    void deleteUser(int id);
}
