package com.codeacademy.webapp.controllers;

import com.codeacademy.webapp.entities.Comment;
import com.codeacademy.webapp.services.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/comment")
public class CommentController {

    CommentService commentService;

    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }

//    @GetMapping("/view")
//    public String viewComment(Model model){
//        model.addAttribute("comment", new Comment());
//        return "view-post";
//    }


    @PostMapping("/create")
    public String createComment(@RequestParam("postId") Long id, Comment comment){
        commentService.saveComment(commentService.createComment(comment, id));
        return "redirect:/post/view?postId=" + id;
    }

}
