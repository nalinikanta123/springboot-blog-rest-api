package com.dream.thoughts.springblogrestapi.service;

import java.util.List;

import com.dream.thoughts.springblogrestapi.entity.Post;
import com.dream.thoughts.springblogrestapi.exceptions.BlogAlreadyExistsException;
import com.dream.thoughts.springblogrestapi.exceptions.BlogNotFoundException;

public interface BlogService {

	Post saveBlog(Post blog) throws BlogAlreadyExistsException;

	List<Post> getAllBlogs() throws BlogNotFoundException;

	Post getBlogById(Long id) throws BlogNotFoundException;

}
