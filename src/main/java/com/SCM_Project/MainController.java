package com.SCM_Project;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/api")
public class MainController {

        @GetMapping("/index")
        public String welcome(Model model) {
            model.addAttribute("name", "yash Sharma");
            model.addAttribute("message", "Welcome to SCM Project");

            return "index"; // This will return the index.html template
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
          @GetMapping("/home")
        public String homePage(Model model){
            return "home"; // This will return the about.html template
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
            return "signup"; // This will return the signup.html template
        }
       
}
