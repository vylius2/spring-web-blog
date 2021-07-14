package com.codeacademy.webapp.entities;


import lombok.Data;
import lombok.extern.apachecommons.CommonsLog;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name="post")
public class Post {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="title")
    private String title;

    @Column(name="text")
    private String text;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime date;

    @ManyToOne(cascade= {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="profile_id")
    private Profile profile;


    @OneToMany(mappedBy = "post",
            fetch=FetchType.LAZY,
            cascade= CascadeType.ALL)
    private List<Comment> comments;

    public Post(){

    }
}
