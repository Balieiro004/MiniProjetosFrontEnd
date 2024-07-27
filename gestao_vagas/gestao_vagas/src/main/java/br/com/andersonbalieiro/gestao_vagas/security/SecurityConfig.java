package br.com.andersonbalieiro.gestao_vagas.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Autowired
    private SecurityFilter securityFilter;
    
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> {
                auth.requestMatchers("/candidate/").permitAll() /*Para os caminho candidate e company liberar para fazer o cadastro sem autenticação */
                    .requestMatchers("/company/").permitAll()
                    .requestMatchers("/auth/company").permitAll()
                    .requestMatchers("/candidate/auth").permitAll();
                auth.anyRequest().authenticated(); /*para o restante que não seja esses de cima todos vão pedir autenticação de usuario */
            })
            .addFilterBefore(securityFilter, BasicAuthenticationFilter.class); //Vou fazer um filtro pra ver se pode passaar para os controler verificando o token que gerou se é válido
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
