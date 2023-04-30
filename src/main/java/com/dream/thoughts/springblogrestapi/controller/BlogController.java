package com.dream.thoughts.springblogrestapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dream.thoughts.springblogrestapi.entity.Post;
import com.dream.thoughts.springblogrestapi.exceptions.BlogNotFoundException;
import com.dream.thoughts.springblogrestapi.service.BlogService;

@RestController
@RequestMapping("api/v1")
public class BlogController {

	@Autowired
	private BlogService blogService;

	@PostMapping("/blog")
	private ResponseEntity<Post> saveBlog(@RequestBody Post post) {
		Post savePost = blogService.saveBlog(post);
		return new ResponseEntity<>(savePost, HttpStatus.CREATED);
	}

	@GetMapping("/blogs")
	private ResponseEntity<List<Post>> getAllBlogs() {
		List<Post> posts = blogService.getAllBlogs();
		return new ResponseEntity<>(posts, HttpStatus.OK);
	}

	@GetMapping("/blog/{id}")
	private ResponseEntity<Post> getBlogById(@PathVariable("id") Long id) {
		try {
			Post post = blogService.getBlogById(id);
			return new ResponseEntity<>(post, HttpStatus.OK);
		} catch (BlogNotFoundException blogNotFoundException) {
			return new ResponseEntity(blogNotFoundException.getMessage(), HttpStatus.CONFLICT);
		}
	}

	@GetMapping("/blog/globalexception/{id}")
	private ResponseEntity<Post> getBlogByIdGlobalExceptionExample(@PathVariable("id") Long id) {
		Post post = blogService.getBlogById(id);
		return new ResponseEntity<>(post, HttpStatus.OK);
	}

}
