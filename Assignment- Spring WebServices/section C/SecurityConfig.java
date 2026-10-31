
package com.example.smartfooddelivery.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable())
             .headers(headers ->headers.frameOptions(frame ->frame.sameOrigin()))
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/h2-console/**").permitAll()
                .requestMatchers(
                    "/menu",
                    "/orders",
                    "/orders/**",
                    "/recommend"
                ).permitAll().requestMatchers("/admin/**").authenticated().anyRequest().permitAll()).httpBasic(Customizer.withDefaults());

        return http.build();
    }


    @Bean
    public UserDetailsService userDetailsService() {

        UserDetails admin = User.withUsername("admin").password("{noop}admin123").roles("ADMIN").build();

        return new InMemoryUserDetailsManager(admin);
    }
}
