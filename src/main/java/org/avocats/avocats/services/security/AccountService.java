package org.avocats.avocats.services.security;

import org.avocats.avocats.dao.security.RoleRepository;
import org.avocats.avocats.dao.security.UtilisateurRepository;
import org.avocats.avocats.entities.security.Role;
import org.avocats.avocats.entities.security.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {

    private final UtilisateurRepository utilisateurRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final ProfilePictureService profilePictureService;

    @Autowired
    public AccountService(UtilisateurRepository utilisateurRepository,
                          RoleRepository roleRepository,
                          PasswordEncoder passwordEncoder,
                          ProfilePictureService profilePictureService) {
        this.utilisateurRepository = utilisateurRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.profilePictureService = profilePictureService;
    }

    public void registerUser(Utilisateur user, MultipartFile profilePicture) throws IOException {
        // Validate and save the profile picture
        if (profilePicture != null && !profilePicture.isEmpty()) {
            String profilePicturePath = profilePictureService.saveProfilePicture(profilePicture);
            user.setPhoto(profilePicturePath);
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Retrieve the "USER" role from the database
        Role userRole = roleRepository.findByName("USER");
        if (userRole == null) {
            throw new RuntimeException("Role 'USER' not found in the database.");
        }

        // Assign the retrieved role to the user
        user.addRole(userRole);

        // Save the user to the database
        utilisateurRepository.save(user);
    }

    public void addUser(Utilisateur user, MultipartFile profilePicture, String role) throws IOException {
        // Validate and save the profile picture
        if (profilePicture != null && !profilePicture.isEmpty()) {
            String profilePicturePath = profilePictureService.saveProfilePicture(profilePicture);
            user.setPhoto(profilePicturePath);
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Validate user fields
        List<String> errors = validateUser(user, profilePicture);
        if (!errors.isEmpty()) {
            throw new IllegalArgumentException(errors.toString());
        }

        // Validate and set the user role
            Role userRole = roleRepository.findByName(role);
            if (userRole == null) {
                throw new RuntimeException("Role not found in the database.");
            }
            user.addRole(userRole);


        // Save the user to the database
        utilisateurRepository.save(user);
    }

    private List<String> validateUser(Utilisateur user, MultipartFile profilePicture) {
        List<String> errors = new ArrayList<>();

        if (user.getNom() == null || user.getNom().isEmpty()) {
            errors.add("Nom est vide");
        }

        if (user.getPrenom() == null || user.getPrenom().isEmpty()) {
            errors.add("Prénom est vide");
        }

        if (profilePicture == null || profilePicture.isEmpty()) {
            errors.add("Photo de profil non fournie");
        }

        if (user.getDatenaiss() == null) {
            errors.add("Date de naissance est vide");
        }

        if (user.getUsername() == null || user.getUsername().isEmpty()) {
            errors.add("Nom d'utilisateur est vide");
        }

        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            errors.add("Mot de passe est vide");
        }

        return errors;
    }
}
