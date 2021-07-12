package com.codeacademy.webapp.repositories;

import com.codeacademy.webapp.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

    List<Profile> findAll ();

}
