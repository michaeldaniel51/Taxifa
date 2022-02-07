package com.danny.taxifa.dto;


import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserLogin {

    @NotNull(message = "Email is required")
    private String username;

    @NotNull(message = "password is required")
    private String password;


//    public UserLogin(@NotNull(message = "Email is required") String username, @NotNull(message = "password is required") String password) {
//        this.username = username;
//        this.password = password;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
}
