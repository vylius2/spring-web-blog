package com.codeacademy.webapp.repositories;

import com.codeacademy.webapp.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    public Optional<Role> findById(Long id);

    public Role findByTitle(String title);
}
