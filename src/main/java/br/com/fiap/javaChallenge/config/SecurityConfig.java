package br.com.fiap.javaChallenge.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Ignorar CSRF apenas para a API, caso esteja lidando com chamadas externas
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers("/api/**")
                )
                .authorizeHttpRequests(auth -> auth
                        // Permissões de URL abertas
                        .requestMatchers("/", "/login", "/api/prompt",
                                "/addNewUsers", "/saveUsers", "/deleteUsers/**",
                                "/users", "/showFormForUpdateUsers/**").permitAll()
                        .anyRequest().authenticated() // Exige autenticação para outras URLs
                )
                .formLogin(login -> login
                        .loginPage("/login")
                        .defaultSuccessUrl("/home", true)
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout") // Defina uma URL explícita de logout, se necessário
                        .logoutSuccessUrl("/login")
                );

        return http.build();
    }
}