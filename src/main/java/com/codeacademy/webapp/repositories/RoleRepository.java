package com.codeacademy.webapp.repositories;

import com.codeacademy.webapp.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
