
package com.src.Controller;



import com.src.Userform.UserForm;
import com.src.enitities.User;
import com.src.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @Autowired
    private UserServices userServices;

    // Home page mapping
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home() {
        return "home";
    }

    // About page mapping
    @RequestMapping("/about")
    public String aboutPage() {
        return "about";
    }

    // Services page mapping
    @RequestMapping("/services")
    public String servicesPage() {
        return "services";
    }

    // Login page mapping
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // Signup page mapping
    @GetMapping("/signup")
    public String signup(Model model) {
        UserForm userForm = new UserForm();
        model.addAttribute("userForm", userForm);  
        return "signup";  
    }

    // Signup processing
//    @PostMapping("/do-signup")
   @RequestMapping(value = "/do-signup", method = RequestMethod.POST)
    public String processRegister(@ModelAttribute UserForm userForm) {

        return "redirect:/signup";
    }

    @GetMapping("/contact")
    public String contactPage() {
        return "contact";
    }
}