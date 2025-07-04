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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String userId;
    private String name;
    private String email;
    private String password;

    @Column(length=5000)
    private String about;
    @Column(length=5000)
    private String profilePic;
    private String phoneNumber;
    private boolean enabled = false; // default is false, user needs to be enabled by admin
    private boolean  emailVerified = false;
    private boolean phoneVerified = false;

    //how user login like google, github, email, etc.
    private providers provider = providers.SELF; // google, github, email, etc.
    private String providerUserId; // unique id from the provider (like google, github, etc)
    private String providerName; // name of the provider (like google, github, etc.)

    @OneToMany(mappedBy="user",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Contact> contacts = new ArrayList<>();

 
}
