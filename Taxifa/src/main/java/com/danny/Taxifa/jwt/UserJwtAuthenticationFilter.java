package com.danny.Taxifa.jwt;

import com.auth0.jwt.algorithms.Algorithm;
import com.danny.Taxifa.dto.Response;
import com.danny.Taxifa.dto.ResponseStatus;
import com.danny.Taxifa.dto.TokenResponse;
import com.danny.Taxifa.dto.UserLogin;
import com.danny.Taxifa.entities.User;
import com.danny.Taxifa.exceptions.CustomException;
import com.danny.Taxifa.utils.TokenUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;

import static com.danny.Taxifa.utils.TokenUtils.EXPIRATION_TIME;
import static java.lang.Long.parseLong;
import static java.time.LocalDateTime.now;
import static java.util.Date.from;

public class UserJwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {




    private final AuthenticationManager authenticationManager;


    public UserJwtAuthenticationFilter(AuthenticationManager authenticationManager){
        this.authenticationManager = authenticationManager;

        setFilterProcessesUrl("/auth/login");
    }


    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) {

        try {

            UserLogin creds = new ObjectMapper()
                    .readValue(req.getInputStream(), UserLogin.class);

            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            creds.getUsername(),
                            creds.getPassword(), new ArrayList<>()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) throws IOException{

        User user = (User)auth.getPrincipal();
        Date issuedAt = from(Instant.now());
        Date expiresAt = new Date(System.currentTimeMillis()+ EXPIRATION_TIME);

        String token = com.auth0.jwt.JWT.create()
                .withSubject(user.getUsername())
                .withIssuedAt(issuedAt)
                .withClaim("username",user.getUsername())
                .withClaim("contact", user.getContact())
                .sign(Algorithm.HMAC512(TokenUtils.SECRET_KEY.getBytes()));


        TokenResponse tokenResponse = TokenResponse.builder()
                .expiresAt(expiresAt)
                .issuedAt(issuedAt)
                .token(token)
                .build();

        Response<?> response = Response.build( ResponseStatus.Successful,tokenResponse);

        res.setContentType(MediaType.APPLICATION_JSON_VALUE);
        res.getWriter().write(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(response));
        res.getWriter().flush();
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                              AuthenticationException failed) throws IOException{


        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        Response<?> res = Response.build(ResponseStatus.Unauthorized,"Incorrect Credentials");


        response.getWriter().write(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(res));
        response.getWriter().flush();

    }





}
