package com.SCM_Project.forms;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class UserForm {

    @NotBlank(message="Name is required")
    @Size(min=2, max=50, message="Name must be between 2 and 50 characters")
    private String name;

    
    @NotBlank(message="Email is required")
    @Email(message="Email should be valid")
    private String email;

    @NotBlank(message="Password is required")
    @Size(min=6, max=100, message="Password must be between 6 and 100 characters")
    @Column(length=100)
    private String password;

    @NotBlank(message="about is required")
    @Column(length=5000)
    private String about;

    @NotBlank(message="Phone number is required")
    @Size(min=8, max=12, message="Phone number must be between 8 and 12 characters")
    private String phoneNumber;
 // ya aur zyada
 @Column(name = "profile_pic", length = 1000)
 private String profilePic;
 
 // URL or path to the profile picture
    
}
