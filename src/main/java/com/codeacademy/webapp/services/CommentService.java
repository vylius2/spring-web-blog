package com.codeacademy.webapp.services;

import com.codeacademy.webapp.entities.Comment;
import com.codeacademy.webapp.entities.Profile;
import com.codeacademy.webapp.repositories.CommentRepository;
import com.codeacademy.webapp.repositories.PostRepository;
import com.codeacademy.webapp.repositories.ProfileRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    private final ProfileRepository profileRepository;

    private final PostRepository postRepository;

    public CommentService(CommentRepository commentRepository, ProfileRepository profileRepository, PostRepository postRepository){
        this.commentRepository = commentRepository;
        this.profileRepository = profileRepository;
        this.postRepository = postRepository;
    }

    public Comment createComment(Comment comment, Long id){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof Profile) {
            comment.setProfile(profileRepository.getProfileById(((Profile)principal).getId()).orElse(null));
            comment.setPost(postRepository.getById(id));
        }
        return comment;
    }
    public Comment saveComment(Comment comment){
        return commentRepository.save(comment);
    }

    public List<Comment> findAllByPostId(Long id){
        return commentRepository.findAllByPostId(id);
    }
}
