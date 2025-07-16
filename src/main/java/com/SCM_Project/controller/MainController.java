package com.SCM_Project.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SCM_Project.entities.Message;
import com.SCM_Project.entities.MessageType;
import com.SCM_Project.entities.User;
import com.SCM_Project.forms.UserForm;
import com.SCM_Project.service.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;


@Controller
@RequestMapping
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

       @GetMapping("/")
    public String index() {
        return "redirect:/home";
    }

    @RequestMapping("/home")
    public String home(Model model) {
        System.out.println("Home page handler");
        // sending data to view
        // model.addAttribute("name", "Substring Technologies");
        // model.addAttribute("youtubeChannel", "Learn Code With Durgesh");
        // model.addAttribute("githubRepo", "https://github.com/learncodewithdurgesh/");
        return "home";
    }

        @GetMapping("/about")
        public String aboutPage(Model model){
            return "about"; // This will return the about.html template
        }

          @GetMapping("/services")
        public String servicePage(Model model){
            return "service"; // This will return the about.html template
        }

           @GetMapping("/navbar")
        public String navPage(Model model){
            return "navbar"; // This will return the about.html template
        }
     

           @GetMapping("/contact")
        public String contactPage(Model model){
            return "contact"; // This will return the about.html template
        }

          @GetMapping("/login")
        public String loginPage(Model model){
            return "login"; // This will return the login.html template
        }

        @GetMapping("/signup")
        public String signupPage(Model model){
            UserForm userForm = new UserForm();
            
            model.addAttribute("userForm", userForm);
            return "signup"; // This will return the signup.html template
        }

        @PostMapping("/register")
public String signup(@Valid @ModelAttribute UserForm userForm, BindingResult result, HttpSession session) {

    if (result.hasErrors()) {
        // If there are validation errors, return to the signup page with errors
        System.out.println("Validation errors occurred during registration.");
        session.setAttribute("message", Message.builder().content("Validation errors occurred").type(MessageType.red).build());
        return "signup";
    }

    User user = new User();
    user.setName(userForm.getName());
    user.setEmail(userForm.getEmail());

    // ✅ Encode the password
    user.setPassword(passwordEncoder.encode(userForm.getPassword()));

    user.setAbout(userForm.getAbout());
    user.setPhoneNumber(userForm.getPhoneNumber());
    user.setProfilePic("https://imgs.search.brave.com/qc5StS_oFfg-VxNXqlxXIB80172gI5Ga2GN8lV_PYTA/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly90My5m/dGNkbi5uZXQvanBn/LzA2LzA3Lzg0Lzgy/LzM2MF9GXzYwNzg0/ODIzMV93NWlGTjR0/TW10STJ3b0pqTWg3/UThtR3ZnQVJuekhn/US5qcGc");

    userService.saveUser(user);

    Message message = Message.builder().content("User registered successfully").type(MessageType.blue).build();
    session.setAttribute("message", message);

    System.out.println("User registered successfully: " + user.getName());
    return "redirect:/signup";
}

       
}
