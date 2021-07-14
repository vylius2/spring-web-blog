package com.codeacademy.webapp.services;

import com.codeacademy.webapp.entities.Post;
import com.codeacademy.webapp.repositories.PostRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    public Page<Post> getAllPostsPaginated(Pageable pageable){
        return postRepository.findAll(pageable);
    }

    public Post savePost(Post post){
        return postRepository.save(post);
    }
}
