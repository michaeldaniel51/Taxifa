package com.danny.taxifa.services;

import com.danny.taxifa.entities.User;
import com.danny.taxifa.repositories.UserRepository;
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
