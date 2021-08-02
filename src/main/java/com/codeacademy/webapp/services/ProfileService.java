package com.codeacademy.webapp.services;

import com.codeacademy.webapp.entities.Profile;
import com.codeacademy.webapp.exceptions.ProfileNotFoundException;
import com.codeacademy.webapp.repositories.ProfileRepository;
import com.codeacademy.webapp.repositories.RoleRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class ProfileService implements UserDetailsService {

    ProfileRepository profileRepository;
    RoleRepository roleRepository;
    PasswordEncoder encoder;

    public ProfileService(ProfileRepository profileRepository, RoleRepository roleRepository, PasswordEncoder encoder){
        this.profileRepository = profileRepository;
        this.roleRepository = roleRepository;
        this.encoder = encoder;
    }


    public void save(Profile profile){
        profileRepository.save(profile);
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        return profileRepository.findByUsername(username).orElseThrow(() -> new ProfileNotFoundException(username));
    }

    public Profile createProfile(Profile profile){
        if (profileRepository.findByUsername(profile.getUsername()).isPresent()){
            return null;
        }
        profile.addRole(roleRepository.findByTitle("USER"));

        profile.setPassword(encoder.encode(profile.getPassword()));
        return profile;
    }

}
