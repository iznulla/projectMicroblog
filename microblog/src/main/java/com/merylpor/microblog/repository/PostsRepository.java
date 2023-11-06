package com.merylpor.microblog.repository;

import com.merylpor.microblog.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {
}
