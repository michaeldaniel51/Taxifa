package com.danny.taxifa.services;

import com.danny.taxifa.annotations.ShowExecutionTime;
import com.danny.taxifa.entities.User;
import com.danny.taxifa.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

    }

    @ShowExecutionTime
    public String addUser(User user) {

        String message;
        message = user.getFirstname() + " you have successfully registered to taxifa \n" +
                "please proceed to confirm your account";


        userRepository.save(user);
        return message;


    }

    public void deleteUser(int userId) {
        userRepository.deleteById(userId);
    }




    public List<User> nameFilter(char namechar){

     List<User> i = findAll()
             .stream()
             .filter(u -> u.getFirstname()
             .startsWith(String.valueOf(namechar)))
             .collect(Collectors.toList());

     return i;
    }




    public List<User> findAll() {

        return userRepository.findAll();
    }



    public Optional<User> findById(int userId) {
        return userRepository.findById(userId);
    }

    @ShowExecutionTime
    public void UpdateUser(User user) {
            userRepository.save(user);
    }


//    public User e(UpdateUserDto updateUserDto){
//        User user = new User();
//        user.setFirst_name(updateUserDto.getFirst_name());
//        user.setLast_name(updateUserDto.getLast_name());
//        return userRepository.save(user);
//    }

//    public List<User> findTypeOfUsers(TypeOfUser typeOfUser){
//
//        return userRepository.findByTypeOfUser(typeOfUser);
//    }




    public List<User> findByFirstName(String firstname){

       return userRepository.findByFirstname(firstname);


    }

    public List<User> findByFirstAndLastName(String firstname,String lastname){
        return userRepository.findByFirstnameAndLastname(firstname, lastname);
    }


    public List<User> findByFirstNameOrLastName(String firstname,String lastname){

        return userRepository.findByFirstnameOrLastname(firstname, lastname);

    }

}
