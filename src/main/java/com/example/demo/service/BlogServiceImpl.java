package com.example.demo.service;

import java.util.List;

import com.example.demo.dao.BlogDAO;
import com.example.demo.model.BlogPost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogDAO blogPostDAO;

    @Transactional
    @Override
    public List<BlogPost> getAllBlogPosts() {
        // TODO: Implement logic to get all blog posts
        return blogPostDAO.getAllBlogPosts();
    }

    @Transactional
    @Override
    public BlogPost getBlogPostById(Long id) {
        // TODO: Implement logic to get a blog post by ID
        return blogPostDAO.getBlogPostById(id);
    }

    @Transactional
    @Override
    public BlogPost createBlogPost(BlogPost blogPost) {
        // TODO: Implement logic for creating a new blog post
         blogPostDAO.save(blogPost);
		return blogPost;
    }

    @Transactional
    @Override
    public BlogPost updateBlogPost(Long id, BlogPost blogPost) {
        // TODO: Implement logic for updating an existing blog post
        // Ensure the provided blog post has the correct ID set
        blogPost.setId(id);
       blogPostDAO.save(blogPost);
	return blogPost;
    }

    @Transactional
    @Override
    public void deleteBlogPost(Long id) {
        // TODO: Implement logic to delete a blog post by ID
        blogPostDAO.deleteBlogPost(id);
    }
}

