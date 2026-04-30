package de.eniprojekte.tacocloud.configuration;

import de.eniprojekte.tacocloud.data.User;
import de.eniprojekte.tacocloud.interfaces.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();

    }

    @Bean
    public UserDetailsService userDetailService (UserRepository repo){

        return username -> {
           User user = repo.findByUsername(username);
            if(user != null ){
                return user;
            }
            throw new UsernameNotFoundException("User " + username +  " not found!");
        };

    }


}
