package de.eniprojekte.tacocloud.configuration;

import de.eniprojekte.tacocloud.data.User;
import de.eniprojekte.tacocloud.interfaces.UserRepository;
import org.springframework.boot.security.autoconfigure.web.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.expression.WebExpressionAuthorizationManager;


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

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http.authorizeHttpRequests(auth -> auth
                                .requestMatchers("/design","/orders/**")
                                .access(new WebExpressionAuthorizationManager("hasRole('USER') OR  hasRole('ADMIN')"))
                                .requestMatchers(HttpMethod.POST,"/api/ingredients").hasAuthority("SCOPE_writeIngredients")
                                .requestMatchers(HttpMethod.DELETE,"/api/ingredients").hasAuthority("SCOPE_deleteIngredients")
                                .requestMatchers(HttpMethod.GET, "/api/orders/**")
                                .hasAuthority("SCOPE_readOrders")
                                .requestMatchers(HttpMethod.POST, "/api/orders/**")
                                .hasAuthority("SCOPE_writeOrders")
                                .requestMatchers(HttpMethod.PUT, "/api/orders/**")
                                .hasAuthority("SCOPE_writeOrders")
                                .requestMatchers(HttpMethod.DELETE, "/api/orders/**")
                                .hasAuthority("SCOPE_deleteOrders")
                                .requestMatchers("/","/**","/h2-console/**")
                                .access(new WebExpressionAuthorizationManager("permitAll()"))
                        )
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(Customizer.withDefaults()))

                .csrf(csrf -> csrf
                        .ignoringRequestMatchers(PathRequest.toH2Console()))
                .headers(headers -> headers.frameOptions(frame -> frame.sameOrigin()))

                .formLogin(form -> form.loginPage("/login").defaultSuccessUrl("/design").permitAll())

                .logout(logout -> logout.logoutSuccessUrl("/logout").permitAll())

                .build();


    }



}
