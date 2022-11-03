package com.pastebin.controllers;

import com.pastebin.Services.UserService;
import com.pastebin.models.ApplicationUser;
import com.pastebin.models.RegistrationObject;
import com.pastebin.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


@Controller
public class AuthenticationController {

    private final UserRepository userRepo;

    private final UserService userService;


    public AuthenticationController(UserRepository userRepo, UserService userService) {
        this.userRepo = userRepo;
        this.userService = userService;
    }


    @GetMapping("/pastebin")
    public String homePage() {
        return "pastebin";
    }


    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("user", new ApplicationUser());
        return "registrationPage";
    }

    @PostMapping("/process_register")
    public String processRegistration(@Valid @ModelAttribute("user") RegistrationObject ro,
                                      BindingResult result,
                                      Model model) {
        ApplicationUser tempUser = userRepo.findByUsername(ro.getUsername());
        if (userRepo.findByUsername(ro.getUsername()) != null) {
            result.rejectValue("username", null);

        }
        if (result.hasErrors()) {
            model.addAttribute("user", ro);
            return "registrationError";
        }
        userService.registerUser(ro);
        return "paste";
    }
}
