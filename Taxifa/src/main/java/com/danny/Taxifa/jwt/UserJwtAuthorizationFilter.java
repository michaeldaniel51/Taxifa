package com.danny.Taxifa.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.danny.Taxifa.utils.TokenUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import static com.danny.Taxifa.utils.TokenUtils.HEADER_NAME;
import static com.danny.Taxifa.utils.TokenUtils.SECRET_KEY;

public class UserJwtAuthorizationFilter extends BasicAuthenticationFilter {





    public UserJwtAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }


    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {

        String header = req.getHeader(HEADER_NAME);

        if (header == null || !header.startsWith("Bearer ")){

            chain.doFilter(req, res);
            return;

        }


        UsernamePasswordAuthenticationToken authentication = getAuthentication(req);

        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(req,res);

    }


    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest req){

        try{

            String token = req.getHeader(HEADER_NAME);

            if (token != null){

                String user = JWT.require(Algorithm.HMAC512(SECRET_KEY.getBytes()))
                        .build()
                        .verify(token.replace("Bearer ",""))
                        .getSubject();

                if(user != null){

                    return new UsernamePasswordAuthenticationToken(user,null, new ArrayList<>());
                }

                return null;
            }


        }catch (Exception ex){
            logger.error(ex.getMessage());
        }
        return null;
    }







}
