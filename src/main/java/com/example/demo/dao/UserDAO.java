package com.example.demo.dao;

import com.example.demo.model.User;

import java.util.List;

public interface UserDAO {

    List<User> getAllUsers();

    User getUserById(int id);

    void save(User user);

    User getUserByEmailAndPasswordAndRole(String email, String password,String role);

    void deleteUser(int id);
}
