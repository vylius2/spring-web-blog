package com.codeacademy.webapp.controllers;

import com.codeacademy.webapp.dto.ProfileDTO;
import com.codeacademy.webapp.entities.Profile;
import com.codeacademy.webapp.exceptions.UserAlreadyExistAuthenticationException;
import com.codeacademy.webapp.services.ProfileService;
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

    private final ProfileService profileService;

    public UserController(ProfileService profileService){
        this.profileService = profileService;
    }
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @PostMapping("/login/error")
    public String failLogin(){

        return "redirect:/login?error";
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
        System.out.println("\n\n\n\n\n\npirmas\n" + profileDTO + "\n\n\n\n\n");
        try {
            profileService.save(profileService.createProfile(new Profile(profileDTO)));
        } catch (UserAlreadyExistAuthenticationException e) {
            e.printStackTrace();
            return "user-exists";
        }
        return "redirect:/user/login";
    }
}
