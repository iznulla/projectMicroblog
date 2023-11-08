package com.merylpor.microblog.repository;

import com.merylpor.microblog.entity.PostsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<PostsEntity, Long> {
}
