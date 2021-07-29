package com.codeacademy.webapp.controllers;

import com.codeacademy.webapp.entities.Profile;
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

    //TODO PERDARYT I CONSTRUCTOR BASED
    @Autowired
    private ProfileService profileService;
    @Autowired
    private RoleService roleService;

    @GetMapping("/login")
    public String login(){
        return "sign-in";
    }

    @GetMapping("/logout")
    public String logout(){
        return "redirect:/user/login";
    }

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("profile", new Profile());
        return "create-account";
    }

    @PostMapping("/save")
    public String createUser(Profile profile){

        profileService.save(profileService.createProfile(profile));
        return "redirect:/user/login";
    }
}
