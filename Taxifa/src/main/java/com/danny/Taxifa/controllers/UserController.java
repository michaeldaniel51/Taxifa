package com.danny.Taxifa.controllers;

import com.danny.Taxifa.annotations.ShowExecutionTime;
import com.danny.Taxifa.entities.User;
import com.danny.Taxifa.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.http.ResponseEntity.status;



@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;


    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody User user){

        return ResponseEntity.ok(userService.addUser(user));
    }

    @GetMapping
    public ResponseEntity<?> getAllUser(){
        return ResponseEntity.ok(userService.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id){
        return ResponseEntity.ok(userService.findById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id){
        userService.deleteUser(id);
    }

    @PutMapping
    public void updateUser(@RequestBody User user){
        userService.UpdateUser(user);
    }


//    @GetMapping("/users/{typeOfUser}")
//    public ResponseEntity<List<User>> typeOfUser(@PathVariable TypeOfUser typeOfUser){
//
//        return ResponseEntity.ok(userService.findTypeOfUsers(typeOfUser));
//    }

    @GetMapping("/name/{firstname}")
    public ResponseEntity<List<User>> findByFirstName(@PathVariable String firstname){
        return ResponseEntity.ok(userService.findByFirstName(firstname));
    }


    @GetMapping("/{firstname}/{lastname}")
    public ResponseEntity<List<User>> findByFirstAndLastName(@PathVariable String firstname ,@PathVariable String lastname){

        return ResponseEntity.ok(userService.findByFirstAndLastName(firstname, lastname));
    }

    @ShowExecutionTime
    @GetMapping("/names")
    public ResponseEntity<List<User>> findByFirstOrLastName(@RequestParam String firstname ,@RequestParam String lastname){
        return ResponseEntity.ok(userService.findByFirstNameOrLastName(firstname, lastname));
    }



//    @PutMapping
//    public ResponseEntity<?> update(UpdateUserDto updateUserDto){
//        return ResponseEntity.accepted().body(userService.e(updateUserDto));
//    }
}
