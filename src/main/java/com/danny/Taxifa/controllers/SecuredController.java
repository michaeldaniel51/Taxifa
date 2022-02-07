package com.danny.taxifa.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/secure")
public class SecuredController {



    @GetMapping
    public ResponseEntity<?> reachSecureEndPoint(){

        return new ResponseEntity("you have reached a secured endPoint",HttpStatus.OK);
    }




}
