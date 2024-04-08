package org.avocats.avocats.controllers.security;

import org.avocats.avocats.entities.security.Utilisateur;
import org.avocats.avocats.services.security.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class RegistrationController {

    private final AccountService accountService;

    @Autowired
    public RegistrationController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new Utilisateur());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") Utilisateur user,
                               @RequestParam("profilePicture") MultipartFile profilePicture) throws IOException {
        accountService.registerUser(user, profilePicture);
        return "redirect:/login";
    }

    @PostMapping("/addUser")
    public ResponseEntity<?> addUser(@ModelAttribute("user") Utilisateur user,
                                     @RequestParam(value = "profilePicture", required = false) MultipartFile profilePicture,
                                     @RequestParam("role") String role) throws IOException {
        accountService.addUser(user, profilePicture, role);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
