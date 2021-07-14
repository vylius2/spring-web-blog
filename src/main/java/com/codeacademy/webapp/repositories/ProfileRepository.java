package com.codeacademy.webapp.repositories;

import com.codeacademy.webapp.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {

    List<Profile> findAll ();

    Optional<Profile> getProfileById(Long id);
}
