package com.codeacademy.webapp.repositories;

import com.codeacademy.webapp.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findAll ();

    Post findPostById(Long id);
}
