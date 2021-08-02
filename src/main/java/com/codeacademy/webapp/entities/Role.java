package com.codeacademy.webapp.entities;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Data
@Entity
@Table(name = "role")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    public Role(){}

    @Override
    public String getAuthority() {
        return "ROLE_" + title;
    }
}
