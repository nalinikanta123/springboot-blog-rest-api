package com.dream.thoughts.springblogrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dream.thoughts.springblogrestapi.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
