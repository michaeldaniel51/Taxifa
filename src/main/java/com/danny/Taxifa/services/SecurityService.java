package com.danny.Taxifa.services;

import com.danny.Taxifa.entities.User;
import com.danny.Taxifa.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class SecurityService {

    @Autowired
    private UserRepository userRepository;


    public User authenticatedUser() {


        User user = userRepository.findByUsername((String) SecurityContextHolder.getContext().getAuthentication().getPrincipal())
                .orElseThrow(()-> new UsernameNotFoundException("cant find user"));
                return user;

    }


    }
