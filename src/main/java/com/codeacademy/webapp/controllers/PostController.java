package com.codeacademy.webapp.controllers;

import com.codeacademy.webapp.dto.PostDTO;
import com.codeacademy.webapp.entities.Comment;
import com.codeacademy.webapp.entities.Post;
import com.codeacademy.webapp.entities.Profile;
import com.codeacademy.webapp.repositories.ProfileRepository;
import com.codeacademy.webapp.services.CommentService;
import com.codeacademy.webapp.services.PostService;
import com.codeacademy.webapp.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


@Controller
@RequestMapping("/post")
public class PostController {
    //TODO PERDARYT I CONSTRUCTOR BASED
    @Autowired
    PostService postService;

    @Autowired
    ProfileRepository profileRepository;

    @Autowired
    ProfileService profileService;

    @Autowired
    CommentService commentService;

    @GetMapping("/list")
    public String listPosts(@PageableDefault(size = 9) Pageable pageable,
                            Model model,
                            HttpServletRequest request){
        model.addAttribute("postsPage", postService.getAllPostsPaginated(pageable));
        return "index";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/create")
    public String createPost(Model model){
        model.addAttribute("postDTO", new PostDTO());
        return "create-post";
    }

    @PostMapping("/save")
    //                     @MODELATTRIBUTE NERA REIKALINGAS!!!!
    public String savePost(@Valid PostDTO postDTO, BindingResult bindingResult){
        //TODO PADARYT KAD RODYTU NEVALIDZIAI UZPILDYTA FORMA
        if(bindingResult.hasErrors()){
            return "create-post";
        }
        postService.savePost(postService.createPost(postDTO));
        return "redirect:/post/list";
    }

    @GetMapping("/delete")
    @PreAuthorize("hasRole('ADMIN')")
    public String deletePost(@RequestParam("postId") Long id){
        postService.deleteById(id);
        return "redirect:/post/list";
    }

    @GetMapping("/edit")
    public String updatePost(@RequestParam("postId") Long id, Model model){
        model.addAttribute("post", postService.findPostById(id));
        return "create-post";
    }
    @GetMapping("/view")
    public String viewPost(@RequestParam("postId") Long id,
                           Model model){
        model.addAttribute("post", postService.findPostById(id));
        model.addAttribute("comment", new Comment());
        model.addAttribute("comments", commentService.findAllByPostId(id));
        return "view-post";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/my/uploads")
    public String viewMyPosts(Model model){
        model.addAttribute("posts", postService.findPostByCurrentProfile());
        return "my-posts";
    }
}
