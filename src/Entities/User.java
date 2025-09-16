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

    @Override
    public String toString() {
        return("ID : " + this.id + "\nFullName :"+ this.fullName + "\nemail : "+ this.email + "\naddress : " + this.address);
    }
}
