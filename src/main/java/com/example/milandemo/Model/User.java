package com.example.milandemo.Model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Required")
    @Column(name="firstName")
    private String firstName;

    @NotBlank(message = "Required")
    @Column(name="lastName")
    private String lastName;

    @NotBlank(message = "Required")
    @Column(name="address")
    private String address;

    @NotBlank(message = "Required")
    @Column(name="email")
    private String email;

    @NotBlank(message = "Required")
    @Column(name="password")
    private  String password;

    @Column(name="isAdmin")
    private boolean isAdmin;

    public User() {
    }

    public User( String firstName, String lastName, String address, String email, String password) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.password = password;
        this.isAdmin = false;
    }


    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }


}
