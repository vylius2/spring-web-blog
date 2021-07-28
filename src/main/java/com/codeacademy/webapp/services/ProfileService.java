package com.codeacademy.webapp.services;

import com.codeacademy.webapp.entities.Profile;
import com.codeacademy.webapp.exceptions.ProfileNotFoundException;
import com.codeacademy.webapp.repositories.ProfileRepository;
import com.codeacademy.webapp.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileService implements UserDetailsService {

    @Autowired
    ProfileRepository profileRepository;

    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder encoder;

    public Profile findById(Long id){

        return profileRepository.getProfileById(id).orElseThrow(() -> new ProfileNotFoundException(id));
    }

    public void save(Profile profile){
        profileRepository.save(profile);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return profileRepository.findByUsername(username).orElse(null);//TODO VIETOJ NULL EXCEPTION
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
