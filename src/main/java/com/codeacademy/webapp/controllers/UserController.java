package com.codeacademy.webapp.controllers;

import com.codeacademy.webapp.dto.ProfileDTO;
import com.codeacademy.webapp.entities.Profile;
import com.codeacademy.webapp.services.ProfileService;
import com.codeacademy.webapp.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@Controller
@RequestMapping("/user")
public class UserController {

    //TODO PERDARYT I CONSTRUCTOR BASED
    @Autowired
    private ProfileService profileService;
    @Autowired
    private RoleService roleService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

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
        model.addAttribute("profileDTO", new ProfileDTO());
        return "create-account";
    }

    @PostMapping("/save")
    public String createUser(@Valid ProfileDTO profileDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "create-account";
        }
        profileService.save(profileService.createProfile(new Profile(profileDTO)));
        return "redirect:/user/login";
    }
}
