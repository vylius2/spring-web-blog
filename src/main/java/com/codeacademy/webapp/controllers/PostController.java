package com.codeacademy.webapp.controllers;

import com.codeacademy.webapp.entities.Post;
import com.codeacademy.webapp.repositories.ProfileRepository;
import com.codeacademy.webapp.services.PostService;
import com.codeacademy.webapp.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/post")
public class PostController {
    //TODO PERDARYT I CONSTRUCTOR BASED
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

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/create")
    public String createPost(Model model){
        model.addAttribute("post", new Post());
        return "create-post";
    }

    @PostMapping("/save")
    //                     @MODELATTRIBUTE NERA REIKALINGAS!!!!
    public String savePost(@ModelAttribute("post") Post post){
        postService.savePost(postService.createPost(post));
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
        LocalDateTime date = LocalDateTime.now();
        System.out.println();
        return "view-post";
    }
 
}
