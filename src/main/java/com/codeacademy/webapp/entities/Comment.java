package com.codeacademy.webapp.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name="comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name = "text")
    private String text;

    @ManyToOne(cascade= {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne(cascade= {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "profile_id")
    private Profile profile;

    public Comment(){

    }
}
