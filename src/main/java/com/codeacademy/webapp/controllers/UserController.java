package com.codeacademy.webapp.controllers;

import com.codeacademy.webapp.entities.Profile;
import com.codeacademy.webapp.entities.Role;
import com.codeacademy.webapp.services.ProfileService;
import com.codeacademy.webapp.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    private ProfileService profileService;
    @Autowired
    private RoleService roleService;

    @GetMapping("/login")
    public String login(){

        return "sign-in";
    }

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("profile", new Profile());
        return "create-account";
    }

    @PostMapping("/save")
    public String createUser(Profile profile){
        profile.addRole(roleService.findById(1L).orElse(null));
        System.out.println(profile);
        System.out.println("VEIKIA SAVE!!!!");
        profileService.save(profile);
        return "redirect:/user/login";
    }
}
