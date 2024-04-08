package org.avocats.avocats.services.security;


import org.avocats.avocats.dao.security.UtilisateurRepository;
import org.avocats.avocats.entities.security.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UtilisateurRepository utilisateurRepository;

    @Autowired
    public CustomUserDetailsService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utilisateur utilisateur = utilisateurRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        return utilisateur;
    }
    public Utilisateur loadUserById(Long userId) {
        return utilisateurRepository.findById(userId)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with id: " + userId));
    }
    
    public List<Utilisateur> getAllUtilisateur(){
		return utilisateurRepository.findAll();
	}
    
    public void deleteUserById(Long id){
		this.utilisateurRepository.deleteById(id);
	}
    
}
