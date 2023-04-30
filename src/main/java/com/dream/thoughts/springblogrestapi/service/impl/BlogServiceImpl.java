package com.dream.thoughts.springblogrestapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dream.thoughts.springblogrestapi.entity.Post;
import com.dream.thoughts.springblogrestapi.exceptions.BlogAlreadyExistsException;
import com.dream.thoughts.springblogrestapi.exceptions.BlogNotFoundException;
import com.dream.thoughts.springblogrestapi.repository.PostRepository;
import com.dream.thoughts.springblogrestapi.service.BlogService;

@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	private PostRepository postRepository;

	@Override
	public Post saveBlog(Post post) throws BlogAlreadyExistsException {
		if (postRepository.existsById(post.getId())) {
			throw new BlogAlreadyExistsException();
		}
		return postRepository.save(post);
	}

	@Override
	public List<Post> getAllBlogs() throws BlogNotFoundException {
		List<Post> list = postRepository.findAll();
		return list;
	}

	@Override
	public Post getBlogById(Long id) throws BlogNotFoundException {
		Post post;
		if (postRepository.findById(id).isEmpty()) {
			throw new BlogNotFoundException("Blog is not available for the given id");
		} else {
			post = postRepository.findById(id).get();
		}
		return post;
	}

}
