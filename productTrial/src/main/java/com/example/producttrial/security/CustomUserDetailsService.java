package com.example.producttrial.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("admin".equals(username)) {
            return org.springframework.security.core.userdetails.User
                    .withUsername("admin")
                    .password("{noop}admin") // {noop} = password en clair
                    .authorities("ROLE_USER")
                    .build();
        } else {
            throw new UsernameNotFoundException("Utilisateur non trouvé");
        }
    }
}
