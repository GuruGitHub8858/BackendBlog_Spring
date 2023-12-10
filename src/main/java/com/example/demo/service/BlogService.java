package com.example.demo.service;



import com.example.demo.model.BlogPost;

import java.util.List;

public interface BlogService {

    List<BlogPost> getAllBlogPosts();

    BlogPost getBlogPostById(Long id);

    BlogPost createBlogPost(BlogPost blogPost);

    BlogPost updateBlogPost(Long id, BlogPost blogPost);

    void deleteBlogPost(Long id);
}
