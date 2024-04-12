package org.avocats.avocats.controllers.security;

import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Controller
public class RedirectController {
	@GetMapping("/redirectByRole")
	public String redirectByRole(Authentication authentication, Model model, HttpSession session) {
	    Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        session.setAttribute("userDetails", authentication.getPrincipal());
	    if (hasRole(authorities, "Admin")) {
	        return "oldIndex";
	    } else if (hasRole(authorities, "User")) {
	        return "User/Index";
        } else if (hasRole(authorities, "avocat")) {
            return "avocat/Index";
        } else if (hasRole(authorities, "secretaire")) {
            return "secretaire/Index";
	    } else {
	        // Unknown role, redirect to default
	        return "redirect:/";
	    }
	}
    private boolean hasRole(Collection<? extends GrantedAuthority> authorities, String targetRole) {
        return authorities.stream()
                .map(GrantedAuthority::getAuthority)
                .anyMatch(role -> role.equalsIgnoreCase(targetRole));
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/index")
    public String showIndexPage() {
        return "index";
    }

 
}
