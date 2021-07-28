package com.codeacademy.webapp.services;

import com.codeacademy.webapp.entities.Post;
import com.codeacademy.webapp.entities.Profile;
import com.codeacademy.webapp.exceptions.ProfileNotFoundException;
import com.codeacademy.webapp.repositories.PostRepository;
import com.codeacademy.webapp.repositories.ProfileRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    ProfileRepository profileRepository;


    public Page<Post> getAllPostsPaginated(Pageable pageable){
        return postRepository.findAll(pageable);
    }

    public Post savePost(Post post){
        return postRepository.save(post);
    }

    public void deleteById(Long id){
        postRepository.deleteById(id);
    }

    public Post findPostById(Long id){
        return postRepository.findPostById(id);
    }

    public Post createPost(Post post){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof Profile) {
            post.setProfile(profileRepository.getProfileById(((Profile)principal).getId()).orElse(null));
        }
        return post;
    }
}
