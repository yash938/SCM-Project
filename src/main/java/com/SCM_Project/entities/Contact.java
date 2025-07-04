package com.SCM_Project.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "contacts")
public class Contact {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private String picture;
    @Column(length=10000)
    private String description;

    private boolean favorite = false; // default is false, user needs to mark as favorite
    // private List<String> SocialLink = new ArrayList<>();

    private String websiteLink;
    private String linkedinLink;
    // Getters and Setters

    @ManyToOne
    private User user;

    @OneToMany(mappedBy="contact",cascade=CascadeType.ALL,fetch=FetchType.EAGER, orphanRemoval=true)
    private List<SocialLinks> socialLinks = new ArrayList<>();
}
