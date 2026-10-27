package br.senac.sp.tads.dsw.exemplo6.config;
 
import java.security.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
 
public class SecurityConfigurations {
 
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                // Necessário para permitir que o console H@ renderize a interface em frames
                .headers(headers -> headers.frameOptions(frame -> frame.sameOrigin()))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                                                    .requestMatchers(
                                                        "/swagger-ui/**",
                                                        "/swagger-ui.html",
                                                        "/v3/api-docs/**",
                                                        "/h2-console/**",
                                                        "/auth/register"
                                                    ).permitAll().anyRequest().authenticated()
                )
                .build();
    }

    @Bean 
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
}
 
 
