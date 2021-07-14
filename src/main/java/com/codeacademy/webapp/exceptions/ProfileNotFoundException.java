package com.codeacademy.webapp.exceptions;

public class ProfileNotFoundException extends RuntimeException{
    private final Long profileId;

    public ProfileNotFoundException(Long profileId){
        this.profileId = profileId;
    }

    public Long getProfileId(){
        return profileId;
    }

}
