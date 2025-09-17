package Entities;

import java.util.UUID;

public class User {
    private UUID id;
    private String fullName;
    private String email;
    private String password;
    private String address;

    public User(String fullName, String email, String password, String address) {
        this.id = UUID.randomUUID();
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.address = address;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public UUID getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return("ID : " + this.id + "\nFullName :"+ this.fullName + "\nemail : "+ this.email + "\naddress : " + this.address);
    }
}
