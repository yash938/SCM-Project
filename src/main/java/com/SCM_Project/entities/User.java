package com.SCM_Project.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User implements  UserDetails {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int userId;
    
   
    private String name;

    private String email;

    
    private String password;

   
  
    private String about;
   
    private String profilePic;

 
    private String phoneNumber;
    




    private boolean enabled = true; // default is false, user needs to be enabled by admin
    private boolean  emailVerified = false;
    private boolean phoneVerified = false;

    //how user login like google, github, email, etc.
    @Enumerated(value=EnumType.STRING)
    private providers provider = providers.SELF; // google, github, email, etc.
    private String providerUserId; // unique id from the provider (like google, github, etc)
    private String providerName; // name of the provider (like google, github, etc.)

    @OneToMany(mappedBy="user",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Contact> contacts = new ArrayList<>();

    private List<String> roles = new ArrayList<>(); // roles like ADMIN, USER, etc.

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role))
                .collect(Collectors.toList());
    }

    @Override
    public String getUsername() {
      return this.email; // Assuming email is used as username
    }

     @Override
    public String getPassword() {
        return this.password;
    }
     @Override
    public boolean isAccountNonExpired() {
        return true;
    }  

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

}
