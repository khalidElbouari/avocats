package org.avocats.avocats.controllers.security;


import org.avocats.avocats.entities.security.Utilisateur;
import org.avocats.avocats.services.security.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @GetMapping("/{userId}")
    public ResponseEntity<Utilisateur> getUserById(@PathVariable Long userId) {
        Utilisateur user = customUserDetailsService.loadUserById(userId);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/all")
    public ResponseEntity<Iterable<Utilisateur>> getAllUtilisateurs() {
        Iterable<Utilisateur> Utilisateurs = customUserDetailsService.getAllUtilisateur();
        return new ResponseEntity<>(Utilisateurs, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id) {
    	customUserDetailsService.deleteUtilisateurparid(id);
    }

}