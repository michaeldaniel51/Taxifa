package com.danny.Taxifa.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Collection;


@Entity
public class User implements UserDetails {


    @Id
    @GeneratedValue
    private int id;
    private String username;
    private String contact;
    private String firstname;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private String lastname;
    private LocalDate date_of_birth; // = LocalDate.now();
//    @OneToMany(orphanRemoval = true,cascade = CascadeType.ALL)
//    @JsonIgnore
//    private List<Driver> driver= new ArrayList<>();


    public User(int id, String username, String contact, String firstname, String password, String lastname, LocalDate date_of_birth) {
        this.id = id;
        this.username = username;
        this.contact = contact;
        this.firstname = firstname;
        this.password = password;
        this.lastname = lastname;
        this.date_of_birth = date_of_birth;
    }

    public User() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(LocalDate date_of_birth) {
        this.date_of_birth = date_of_birth;
    }


    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", contact='" + contact + '\'' +
                ", firstname='" + firstname + '\'' +
                ", password='" + password + '\'' +
                ", lastname='" + lastname + '\'' +
                ", date_of_birth=" + date_of_birth +
                '}';
    }
}
