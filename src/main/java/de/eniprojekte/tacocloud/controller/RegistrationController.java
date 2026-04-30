package de.eniprojekte.tacocloud.controller;

import de.eniprojekte.tacocloud.data.RegistrationForum;
import de.eniprojekte.tacocloud.interfaces.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public RegistrationController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String registerForm(){

        return "registration";

    }

    @PostMapping
    public String processRegistration(RegistrationForum registrationForm){

        userRepository.save(registrationForm.toUser(passwordEncoder));
        return "redirect:/login";
    }


}
