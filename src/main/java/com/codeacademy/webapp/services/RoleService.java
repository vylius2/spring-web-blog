package com.codeacademy.webapp.services;

import com.codeacademy.webapp.entities.Role;
import com.codeacademy.webapp.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepository;

    public Optional<Role> findById(Long id){
        return roleRepository.findById(id);
    }
}
