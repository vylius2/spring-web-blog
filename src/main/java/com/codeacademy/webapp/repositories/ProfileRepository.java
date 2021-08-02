package com.codeacademy.webapp.repositories;

import com.codeacademy.webapp.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {

    Optional<Profile> getProfileById(Long id);


    Optional<Profile> findByUsername(String username);
}
