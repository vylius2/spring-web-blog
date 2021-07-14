package com.codeacademy.webapp.controllers;

import com.codeacademy.webapp.entities.Post;
import com.codeacademy.webapp.repositories.ProfileRepository;
import com.codeacademy.webapp.services.PostService;
import com.codeacademy.webapp.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;

    @Autowired
    ProfileService profileService;

    @GetMapping("/list")
    public String listPosts(@PageableDefault(size = 9) Pageable pageable,
                            Model model,
                            HttpServletRequest request){
        model.addAttribute("postsPage", postService.getAllPostsPaginated(pageable));
        return "index";
    }

    @GetMapping("/create")
    public String createPost(Model model){
        model.addAttribute("post", new Post());
        return "create-post";
    }

    @PostMapping("/save")
    public String savePost(@ModelAttribute("post") Post post){
        System.out.println("\n\n\n\n\n\n" + post + profileService.findById(1L) +  "\n\n\n\n\n\n\n\n");
        post.setProfile(profileService.findById(1L));//TODO ISTRINT
        System.out.println(post);
        postService.savePost(post);
        return "redirect:/index";
    }
}
