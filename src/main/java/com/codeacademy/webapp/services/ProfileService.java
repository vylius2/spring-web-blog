package com.codeacademy.webapp.services;

import com.codeacademy.webapp.entities.Profile;
import com.codeacademy.webapp.exceptions.ProfileNotFoundException;
import com.codeacademy.webapp.repositories.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileService {

    @Autowired
    ProfileRepository profileRepository;

    public Profile findById(Long id){

        return profileRepository.getProfileById(id).orElseThrow(() -> new ProfileNotFoundException(id));
    }

    public void save(Profile profile){
        profileRepository.save(profile);
    }
}
