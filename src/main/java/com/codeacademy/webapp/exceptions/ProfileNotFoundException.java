package com.codeacademy.webapp.exceptions;

public class ProfileNotFoundException extends RuntimeException{
    private final String username;

    public ProfileNotFoundException(String username){
        this.username = username;
    }

    public String getProfileUsername(){
        return username;
    }

}
