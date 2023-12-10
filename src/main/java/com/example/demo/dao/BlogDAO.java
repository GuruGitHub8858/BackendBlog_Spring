package com.example.demo.dao;

import com.example.demo.model.BlogPost;

import java.util.List;

public interface BlogDAO {

    List<BlogPost> getAllBlogPosts();

    BlogPost getBlogPostById(Long id);

    void save(BlogPost blogPost);

    // Add any additional methods specific to BlogPost entity

    void deleteBlogPost(Long id);
}
