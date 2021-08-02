package com.codeacademy.webapp.repositories;

import com.codeacademy.webapp.entities.Post;
import com.codeacademy.webapp.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    Post findPostById(Long id);

    void deleteById(Long id);

    List<Post> findPostsByProfile(Profile profile);

}
