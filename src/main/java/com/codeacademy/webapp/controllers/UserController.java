package com.codeacademy.webapp.controllers;

import com.codeacademy.webapp.entities.Profile;
import com.codeacademy.webapp.entities.Role;
import com.codeacademy.webapp.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    ProfileService profileService;

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
        Set<Role> roles = new HashSet<>();
//        roles.add(Role.USER);
        profile.setRoleSet(roles);
        System.out.println(profile);
        System.out.println("VEIKIA SAVE!!!!");
        profileService.save(profile);
        return "redirect:/user/login";
    }
}
