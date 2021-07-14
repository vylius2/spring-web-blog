package com.codeacademy.webapp.services;

import com.codeacademy.webapp.entities.Profile;
import com.codeacademy.webapp.repositories.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileService {

    ProfileRepository profileRepository;

    public Profile findById(Long id){

        return profileRepository.getProfileById(id).orElse(null);
    }
}
