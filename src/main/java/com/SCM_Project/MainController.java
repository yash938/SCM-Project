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
}
