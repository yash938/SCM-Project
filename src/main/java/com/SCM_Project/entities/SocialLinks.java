package com.SCM_Project.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SocialLinks {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String link;
    private String title;

    @ManyToOne
    private User user;

    @ManyToOne
    private Contact contact;
}
