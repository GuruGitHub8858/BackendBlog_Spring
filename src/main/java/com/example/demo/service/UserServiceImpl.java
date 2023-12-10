package com.example.demo.service;

import com.example.demo.dao.UserDAO;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Transactional
    @Override
    public List<User> getAllUsers() {
        // TODO: Implement logic to get all users
        return userDAO.getAllUsers();
    }

    @Transactional
    @Override
    public User getUserById(int id) {
        // TODO: Implement logic to get a user by ID
        return userDAO.getUserById(id);
    }

    @Transactional
    @Override
    public void signup(User user) {
        // TODO: Implement logic for user registration (signup)
        userDAO.save(user);
    }

    @Transactional
    @Override
    public User login(String email, String password,String role) {
        // TODO: Implement logic for user login
        return userDAO.getUserByEmailAndPasswordAndRole(email, password,role);
    }

    @Transactional
    @Override
    public void deleteUser(int id) {
        // TODO: Implement logic to delete a user by ID
        userDAO.deleteUser(id);
    }
}
