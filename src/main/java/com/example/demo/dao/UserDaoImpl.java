package com.example.demo.dao;

import com.example.demo.model.User;

import jakarta.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class UserDaoImpl implements UserDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<User> query = currentSession.createQuery("from User", User.class);
        return query.getResultList();
    }

    @Override
    public User getUserById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.get(User.class, id);
    }

    @Override
    public void save(User user) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.save(user);
    }

    @Override
    public User getUserByEmailAndPasswordAndRole(String email, String password, String role) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<User> query = currentSession.createQuery(
                "FROM User WHERE email = :email AND password = :password AND role = :role",
                User.class
        );
        query.setParameter("email", email);
        query.setParameter("password", password);
        query.setParameter("role", role);
        return query.uniqueResult();
    }

    @Override
    public void deleteUser(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        User userToDelete = currentSession.get(User.class, id);
        currentSession.delete(userToDelete);
    }
}