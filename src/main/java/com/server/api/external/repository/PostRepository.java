package com.server.api.external.repository;

import com.server.api.external.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<Post> findByUserIdAndTitle(Long userId, String title);
}
