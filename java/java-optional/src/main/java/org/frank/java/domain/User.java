package org.frank.java.domain;

import java.util.Optional;

public class User {
    private String position;
    private String email;
    private String username;
    
    private Address address;
    
    public User(String email,String username){
        this.email = email;
        this.username = username;
    }

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Optional<String> getPosition() {
        return Optional.ofNullable(position);
    }

    public Optional<Address> getAddress() {
        return Optional.ofNullable(address);
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
