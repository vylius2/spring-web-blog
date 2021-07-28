package com.codeacademy.webapp.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

//@Getter
//@Setter
@Data
@Entity
@Table(name = "role")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;


//    //TODO PAMEGINT BE SITO
//    @ManyToMany(fetch = FetchType.LAZY,
//            cascade = {CascadeType.DETACH, CascadeType.MERGE,
//                    CascadeType.PERSIST, CascadeType.REFRESH})
//    @JoinTable(name = "profile_role",
//                    joinColumns = @JoinColumn(name = "role_id"),
//                    inverseJoinColumns = @JoinColumn(name = "profile_id"))
//    private Set<Profile> profiles;
    public Role(){}

    @Override
    public String getAuthority() {
        return "ROLE_" + title;
    }
}
