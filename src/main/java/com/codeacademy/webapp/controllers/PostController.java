package com.codeacademy.webapp.controllers;

import com.codeacademy.webapp.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping("/list")
    public String listPosts(@PageableDefault(size = 3) Pageable pageable,
                            Model model,
                            HttpServletRequest request){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n");
        model.addAttribute("postsPage", postService.getAllPostsPaginated(pageable));
        return "index";

    }
}
