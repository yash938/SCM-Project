package com.SCM_Project.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SCM_Project.entities.User;
import com.SCM_Project.exception.ResourceNotFoundException;
import com.SCM_Project.repository.UserRepo;
import com.SCM_Project.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo userRepo;

    @Override
    public User saveUser(User user) {
        log.info("Saving user: {}", user);
         return  userRepo.save(user);  
    }  
      
    @Override
    public Optional<User> getUserById(int id) {
       User user = userRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("User not found with id: " + id));
      return Optional.of(user);
    }

    @Override
    public User getUserByEmail(String email) {
      return  userRepo.findByEmail(email);
    }

    @Override
    public Optional<User> updateUser(User user, int id) {
        User existingUser = getUserById(id).orElseThrow(()->new ResourceNotFoundException("User not found with id: " + id)); // Check if user exists
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        existingUser.setPhoneNumber(user.getPhoneNumber());
        existingUser.setProfilePic(user.getProfilePic());
        existingUser.setAbout(user.getAbout());
        existingUser.setEnabled(user.isEnabled());
        existingUser.setEmailVerified(user.isEmailVerified());
        existingUser.setPhoneVerified(user.isPhoneVerified());

        existingUser.setProvider(user.getProvider());
        existingUser.setProviderUserId(user.getProviderUserId());


        userRepo.save(existingUser);
        return Optional.of(existingUser);
    }

    @Override
    public void deleteUser(int id) {
        User user = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        userRepo.delete(user);
    }

    @Override
    public boolean isUserPresent(int userId) {
        User user = userRepo.findById(userId).orElse(null);
        return user != null ? true : false;
    }
    
    @Override
    public boolean isUserPresentByEmail(String email) {
        User user = userRepo.findByEmail(email).orElse(null);
        return user != null ? true : false;
    }
    

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

}
