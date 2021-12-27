package com.danny.Taxifa.controllers;

import com.danny.Taxifa.annotations.LogExecutionTime;
import com.danny.Taxifa.dto.Response;
import com.danny.Taxifa.dto.UserDto;
import com.danny.Taxifa.entities.User;
import com.danny.Taxifa.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/user")
public class UserController {


    private final String PORT;
    private final ObjectMapper objectMapper;
    private final UserService userService;

    @Autowired
    public UserController(@Value("${server.port}") String PORT, ObjectMapper objectMapper, UserService userService) {
        this.PORT = PORT;
        this.objectMapper = objectMapper;
        this.userService = userService;
    }


//    @Autowired
//    private UserService userService;

    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody User user){

        return ResponseEntity.ok(userService.addUser(user));
    }

    @GetMapping
    public ResponseEntity<?> getAllUser(){
        return ResponseEntity.ok(userService.findAll());
    }


    @PostMapping("/auth/")
    public ResponseEntity<?> authenticateUser(@RequestBody UserDto userDto) throws IOException {

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost httpPost = new HttpPost("http://localhost:" + PORT + "/user/auth/");
        httpPost.setEntity(new StringEntity(objectMapper.writeValueAsString(userDto)));

        CloseableHttpResponse response = httpClient.execute(httpPost);
        Response<?> responseEntity = objectMapper.readValue(response.getEntity().getContent(), Response.class);

        if (response.getStatusLine().getStatusCode() == 200){

            return ok(responseEntity);
        }else {
            return status(401)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(responseEntity);
        }
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

    @LogExecutionTime
    @GetMapping("/names")
    public ResponseEntity<List<User>> findByFirstOrLastName(@RequestParam String firstname ,@RequestParam String lastname){
        return ResponseEntity.ok(userService.findByFirstNameOrLastName(firstname, lastname));
    }



//    @PutMapping
//    public ResponseEntity<?> update(UpdateUserDto updateUserDto){
//        return ResponseEntity.accepted().body(userService.e(updateUserDto));
//    }
}
