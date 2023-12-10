package com.example.demo.dao;

import com.example.demo.model.BlogPost;

import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BlogDAOImpl implements BlogDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<BlogPost> getAllBlogPosts() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<BlogPost> query = currentSession.createQuery("from BlogPost", BlogPost.class);
        return query.getResultList();
    }

    @Override
    public BlogPost getBlogPostById(Long id) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.get(BlogPost.class, id);
    }

    @Override
    public void save(BlogPost blogPost) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.save(blogPost);
    }

    @Override
    public void deleteBlogPost(Long id) {
        Session currentSession = entityManager.unwrap(Session.class);
        BlogPost blogPostToDelete = currentSession.get(BlogPost.class, id);
        currentSession.delete(blogPostToDelete);
    }

    // Additional methods as needed for BlogPost entity
}
