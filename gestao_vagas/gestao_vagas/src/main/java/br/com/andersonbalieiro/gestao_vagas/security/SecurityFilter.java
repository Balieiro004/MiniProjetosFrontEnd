package br.com.andersonbalieiro.gestao_vagas.security;

import java.io.IOException;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.andersonbalieiro.gestao_vagas.providers.JWTProvider;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter{

    @Autowired
    private JWTProvider jwtProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        SecurityContextHolder.getContext().setAuthentication(null);
        String header = request.getHeader("Authorization");

        //Validando o token que stá vindo no authorization
        if (header != null) {
            var subjectToken = this.jwtProvider.validadeToken(header);
            if (subjectToken.isEmpty()) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }
            request.setAttribute("company_id", subjectToken);
            UsernamePasswordAuthenticationToken auth =
            new UsernamePasswordAuthenticationToken(subjectToken, null, Collections.emptyList()); //subjectToken -> é a inf que eu tenho, null -> São as credenciais que eu não tenho, Collections -> lista de autorizações
            SecurityContextHolder.getContext().setAuthentication(auth); //Pra que todas as requisições o sping tenha as inf do usuario para autenticar se tem ou não autorização
        }
        
        filterChain.doFilter(request, response); //Aqui ele valida se está certo o token e libera passar para a controller
    }
    
}
